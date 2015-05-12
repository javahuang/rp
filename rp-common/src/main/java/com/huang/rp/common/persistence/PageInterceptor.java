/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.springframework.stereotype.Component;

import com.huang.rp.common.persistence.fliter.QueryFilter;
import com.huang.rp.common.utils.ReflectionUtils;
import com.huang.rp.common.web.filter.BaseFilter;

/**
 * @Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
 * 参加 http://mybatis.github.io/mybatis-3/zh/configuration.html#plugins
 * MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用 通过注解定义
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月14日 下午8:35:29
 * <p>Version: 1.0
 */
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PageInterceptor implements Interceptor {

    /**
     * 拦截后要执行的方法
     */

    @SuppressWarnings({"rawtypes", "unchecked", "unused"})
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler) ReflectionUtils.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object obj = boundSql.getParameterObject();
        String sqls = boundSql.getSql();
   
        if (obj instanceof QueryFilter) {
        	QueryFilter queryFilter = (QueryFilter) obj;
            MappedStatement mappedStatement = (MappedStatement) ReflectionUtils.getFieldValue(delegate,
                    "mappedStatement");

            Connection connection = (Connection) invocation.getArgs()[0];
            String sql = boundSql.getSql();
            this.setTotalRecord(queryFilter, mappedStatement, connection);
            String pageSql = this.getPageSql(queryFilter, sql);
            
            ReflectionUtils.setFieldValue(boundSql, "sql", pageSql);
            QueryFilter.setLocal(queryFilter);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 给当前的参数对象page设置总记录数
     */
    private void setTotalRecord(QueryFilter filter, MappedStatement mappedStatement, Connection connection) {
        BoundSql boundSql = mappedStatement.getBoundSql(filter);
        String sql = boundSql.getSql();
        String countSql = this.getCountSql(sql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql,
                parameterMappings, boundSql.getParameterObject());
        MetaObject metaParameters = (MetaObject) ReflectionUtils.getFieldValue(boundSql, "metaParameters");
        ReflectionUtils.setFieldValue(countBoundSql, "metaParameters", metaParameters);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, filter,
                countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                filter.setRecords(totalRecord);
                int rows = filter.getRows();
                // 计算总页数
                int total = totalRecord / rows;
                total = totalRecord % rows == 0 ? total : total + 1;
                filter.setTotalPage(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     *
     * @param sql
     * @return
     */
    private String getCountSql(String sql) {
        return "select count(1) from (" + sql + ") total";////mysql必须加别名|oracle不需要
    }

    /**
     * 根据page对象获取对应的分页查询Sql语句 mysql
     *
     * @param filter 条件对象
     * @param sql    原sql语句
     * @return
     */
    private String getPageSql(QueryFilter filter, String sql) {
        Integer page = filter.getPage() < 1 ? 1 : filter.getPage();
        Integer rows = filter.getRows();
        StringBuilder sqlBuffer = new StringBuilder(sql);
        
        if (page == 1 && rows == 1) {
            sqlBuffer.append(" limit 1 ");
        } else {//0,4 4,4
            int offset = (page-1)* rows;
            sqlBuffer.append(" limit ").append(offset).append(",").append(rows);
        }
        return sqlBuffer.toString();
    }
}

