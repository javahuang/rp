/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common;

/**
 * 常量定义
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月23日 下午3:18:40
 * <p>Version: 1.0
 */
public interface Constants {
	
	/**上下文的根*/
	String WEB_CONTEXT="ctx";
	
	/*ehcache*/
	/**用户缓存*/
	String CACHE_SYS_USER="userCache";
	/**系统参数*/
	String CACHE_SYS_PARAMETER="parameterCache";
	
	/*系统参数*/
	/**标签*/
	String SYS_PARAMETER_TAGS="T001";
	
	
	/**postList分页每页显示条目*/
	Integer POST_LIST_PAGE_SIZE=10;
	/**cookie名*/
	String COOKIE_NAME_SEARCH="search";
	String COOKIE_NAME_TAG="tag";
}
