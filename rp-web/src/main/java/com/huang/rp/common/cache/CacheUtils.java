/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.cache;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huang.rp.common.Constants;
import com.huang.rp.common.cache.dao.SysParameterMapper;
import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.cache.domain.SysParameterExample;
import com.huang.rp.common.utils.ReflectionUtils;
import com.huang.rp.sys.rbac.dao.SysUserMapper;
import com.huang.rp.sys.rbac.domain.SysUser;

/**
 * 提高缓存命中率,尽量保证set的数据都能get到
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年5月5日 下午4:28:51
 * <p>
 * Version: 1.0
 */
public class CacheUtils {

	@Autowired
	SysUserMapper userMapper;// 用户
	@Autowired
	SysParameterMapper sysParameterMapper;// 系统参数

	/**
	 * 执行缓存的初始化操作
	 */
	public void init() {
		userCacheInit();
		parameterCacheInit();
	}

	/**
	 * 刷新特定缓存
	 * 
	 * @param cacheName
	 */
	public void refreshCache(String cacheName) {
		switch (cacheName) {
		case Constants.CACHE_SYS_USER:
			userCacheInit();
			break;
		case Constants.CACHE_SYS_PARAMETER:
			parameterCacheInit();
			break;
		default:
			init();
			break;
		}
	}

	/**
	 * 初始化用户缓存
	 */
	public void userCacheInit() {
		List<SysUser> userList = userMapper.selectByExample(null);
		List<Element> userElementList = Lists.newArrayList();
		for (SysUser user : userList) {
			userElementList.add(new Element(user.getId(), user));
		}
		Cache userCache = getCacheManager().getCache(Constants.CACHE_SYS_USER);
		userCache.putAll(userElementList);
	}

	/**
	 * 初始化系统参数缓存
	 */
	public void parameterCacheInit() {
		SysParameterExample parameterExample = new SysParameterExample();
		parameterExample.createCriteria().andIsValidEqualTo(true);
		parameterExample.setOrderByClause("weight asc");// 按照权重排序
		List<SysParameter> sysParameterList = sysParameterMapper
				.selectByExample(parameterExample);
		Cache parameterCache = getCacheManager().getCache(
				Constants.CACHE_SYS_PARAMETER);
		Map<String, List<SysParameter>> paraMap = Maps.newHashMap();
		for (SysParameter para : sysParameterList) {// 缓存的key为paraType
													// value为SysParameter对象
			String paraType = para.getParaCode();
			if (paraMap.get(paraType) == null) {
				List<SysParameter> paraList = Lists.newArrayList();
				paraList.add(para);
				paraMap.put(paraType, paraList);
			} else {
				paraMap.get(paraType).add(para);
			}
		}
		for (Map.Entry<String, List<SysParameter>> paraList : paraMap
				.entrySet()) {
			parameterCache.put(new Element(paraList.getKey(), paraList
					.getValue()));
		}
	}

	public static CacheManager getCacheManager() {
		return CacheManager.getInstance();
	}

	/**
	 * 得到某个缓存使用次数
	 * 
	 * @param cacheName
	 */
	public static void getStatistics(String cacheName) {
		getCacheManager().getCache(cacheName).getStatistics().getInMemoryHits();// 换取缓存命中次数
	}

	/**
	 * 获取缓存对象
	 * 
	 * @param cacheName
	 * @param key
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getCacheValue(String cacheName, Object key, Class<T> t) {
		Validate.notNull(cacheName);
		Validate.notNull(key);
		return (T) getCacheManager().getCache(cacheName).get(key)
				.getObjectValue();
	}

	public static <T> Object getCacheValueAttribute(String cacheName,
			Object key, String attrName, Class<T> t) {
		Validate.notNull(attrName);
		return ReflectionUtils.getFieldValue(getCacheValue(cacheName, key, t),
				attrName);
	}
	
	public static void setCallValue(String cacheName,Object key,Object value){
		getCacheManager().getCache(cacheName).put(new Element(key, value));
	}
}
