/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.cache.domain;

import net.sf.ehcache.Element;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月27日 下午4:22:31
 * <p>Version: 1.0
 */
public class CacheEntity extends Element {

	/**
	 * @param key
	 * @param value
	 */
	public CacheEntity(Object key, Object value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	

}
