/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.controller;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.huang.rp.common.cache.CacheUtils;
import com.huang.rp.common.persistence.domain.Pagination;
import com.huang.rp.common.persistence.domain.PaginationContext;
import com.huang.rp.common.web.controller.BaseController;
import com.huang.rp.web.sys.domain.CacheEntity;
import com.huang.rp.web.sys.fliter.CacheFilter;

/**
 * 系统管理控制器
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月13日 下午5:26:24
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/sys")
public class SysController extends BaseController{
	
	@Autowired 
	CacheUtils cacheUtils;
	
	/**
	 * 系统缓存管理
	 */
	@RequestMapping("/cache")
	public String cacheManager(){
		return "sys/cache/init";
	}
	/**
	 * 缓存表格初始化
	 * @param filter
	 * @return
	 */
	@RequestMapping("/cache/gridInit")
	@ResponseBody
	public  Pagination<CacheEntity> gridInit(CacheFilter filter){
		CacheManager cacheManager=CacheUtils.getCacheManager();
		String[]cacheNames=cacheManager.getCacheNames();
		List<CacheEntity>cacheList=Lists.newArrayList();
		for(String cacheName:cacheNames){
			Cache currCache=cacheManager.getCache(cacheName);
			CacheEntity entity=new CacheEntity();
			entity.setCacheName(cacheName);
			entity.setSize(currCache.getSize());
			entity.setMemoryHits(currCache.getStatistics().getCacheHits());
			entity.setMemortMisses(currCache.getStatistics().getCacheMisses());
			entity.setDiskStoreSize(currCache.getDiskStoreSize());
			entity.setMemoryStoreSize(currCache.getMemoryStoreSize());
			cacheList.add(entity);
		}
		Pagination<CacheEntity>response=PaginationContext.getPagination();
		response.setRows(cacheList);
		return response;
	}
	/**
	 * 刷新缓存
	 * @param cacheName
	 * @return
	 */
	@RequestMapping("/cache/refreshCache")
	@ResponseBody
	public String refreshCache(String cacheName){
		try{
			cacheUtils.refreshCache(cacheName);
			return "刷新成功";
		}catch(Exception e){
			return "刷新失败";
		}
	}

}
