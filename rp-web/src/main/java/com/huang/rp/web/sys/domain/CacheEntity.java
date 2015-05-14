/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.domain;

/**
 * 缓存查询实体
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月13日 下午11:32:24
 * <p>Version: 1.0
 */
public class CacheEntity {
	String cacheName;
	Long memoryHits;//缓存撞击次数
	Long memortMisses;//缓存丢失数
	int size;//缓存items
	Long memoryStoreSize;
	int diskStoreSize;
	
	public String getCacheName() {
		return cacheName;
	}
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}
	public Long getMemoryHits() {
		return memoryHits;
	}
	public void setMemoryHits(Long memoryHits) {
		this.memoryHits = memoryHits;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Long getMemoryStoreSize() {
		return memoryStoreSize;
	}
	public void setMemoryStoreSize(Long memoryStoreSize) {
		this.memoryStoreSize = memoryStoreSize;
	}
	public int getDiskStoreSize() {
		return diskStoreSize;
	}
	public void setDiskStoreSize(int diskStoreSize) {
		this.diskStoreSize = diskStoreSize;
	}
	public Long getMemortMisses() {
		return memortMisses;
	}
	public void setMemortMisses(Long memortMisses) {
		this.memortMisses = memortMisses;
	}
	
}
