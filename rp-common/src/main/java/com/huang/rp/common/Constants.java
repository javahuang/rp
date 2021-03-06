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
	/**鼻子的url*/
	String WEB_RCL_URL="rencl";
	/**鼻子的id号*/
	Long WEB_RCL_USER_ID=3l;
	
	/*ehcache*/
	/**用户缓存*/
	String CACHE_SYS_USER="userCache";
	/**系统参数*/
	String CACHE_SYS_PARAMETER="parameterCache";
	
	/*系统参数*/
	/**标签*/
	String SYS_PARAMETER_TAGS="T001";
	/**每日一记*/
	String SYS_PARAMETER_VALUE_DAILY_WRITE="9";
	
	/**postList分页每页显示条目*/
	Integer POST_LIST_PAGE_SIZE=10;
	/**cookie名*/
	String COOKIE_NAME_SEARCH="search";
	String COOKIE_NAME_TAG="tag";
	String COOKIE_NAME_USER="user";
	String COOKIE_NAME_PASSWORD="pwd";
	
	/*文章状态*/
	/**已发表*/
	String POST_STATUS_PUBLISH="publish";
	/**中断*/
	String POST_STATUS_INTERRUPT="interrupt";
	/**无效*/
	String POST_STATUS_INVALID="invalid";
	
}
