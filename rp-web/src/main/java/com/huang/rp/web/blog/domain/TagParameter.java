/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.blog.domain;

import com.huang.rp.common.Constants;
import com.huang.rp.common.cache.CacheUtils;
import com.huang.rp.common.cache.domain.SysParameter;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月25日 上午3:07:48
 * <p>Version: 1.0
 */
public class TagParameter extends SysParameter{
	
	public String getUserName(){
		return (String)CacheUtils.getCacheValueAttribute(Constants.CACHE_SYS_USER,  getParaGroup().longValue(),"username", null);
	}
}
