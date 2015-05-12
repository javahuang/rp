/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.cache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.huang.rp.common.Constants;
import com.huang.rp.common.utils.ReflectionUtils;
import com.huang.rp.sys.rbac.dao.SysUserMapper;
import com.huang.rp.sys.rbac.domain.SysUser;

/**
 * 提高缓存命中率,尽量保证set的数据都能get到
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月5日 下午4:28:51
 * <p>Version: 1.0
 */
public class CacheUtils {

	
	@Autowired
	SysUserMapper userMapper;//用户
	
	/**
	 * 执行缓存的初始化操作
	 */
	public void init(){
		//初始化用户缓存
		List<SysUser>userList=userMapper.selectByExample(null);
		List<Element> userElementList=Lists.newArrayList();
		for(SysUser user:userList){
			userElementList.add(new Element(user.getId(), user));
		}
		Cache userCache=getCacheManager().getCache(Constants.CACHE_SYS_USER);
		userCache.putAll(userElementList);
	}
	
	public static CacheManager getCacheManager(){
		return CacheManager.getInstance();
	}
	
	public static void getStatistics(String cacheName){
		getCacheManager().getCache(cacheName).getStatistics().getInMemoryHits();//换取缓存命中次数
	}
	
	/**
	 * 获取缓存对象
	 * @param cacheName
	 * @param key
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getCacheValue(String cacheName,Object key,Class<T> t){
		Validate.notNull(cacheName);
		Validate.notNull(key);
		return (T)getCacheManager().getCache(cacheName).get(key).getObjectValue();
	}
	
	public static <T> Object getCacheValueAttribute(String cacheName,Object key,String attrName,Class<T> t){
		Validate.notNull(attrName);
		return ReflectionUtils.getFieldValue(getCacheValue(cacheName,key,t),attrName);
	}


}
