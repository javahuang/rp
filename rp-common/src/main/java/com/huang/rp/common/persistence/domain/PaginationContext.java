/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.persistence.domain;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 分页信息上下文
 * 向上提供Pagination给mybatis设置分页参数
 * 向下提供给Controller设置查询实体参数
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月22日 下午6:53:02
 * <p>Version: 1.0
 */
@SuppressWarnings("unchecked")
public class PaginationContext {
	
	@SuppressWarnings("rawtypes")
	public static ThreadLocal<Pagination> pag=new ThreadLocal<Pagination>();
	
	public static <T> Pagination<T>  getPagination(){
		Pagination<T> pagination=pag.get();
		if(pagination==null){
			pagination=new Pagination<T>();
		}
		return pagination;
	}
	
	public static <T> Pagination<T>  getPagination(List<T>dataList){
		if(CollectionUtils.isEmpty(dataList)){
			return new Pagination<T>();
		}
		//直接getPagination().setDataList(dataList)会出现异常 编译器不能保证get的类型会和T是一致的
		Pagination<T> pagination=(Pagination<T>)getPagination();
		return pagination.setDataList(dataList);
	}

}
