/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huang.rp.common.web.controller.BaseController;

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
	
	/**
	 * 系统缓存管理
	 */
	@RequestMapping("/cache")
	public String cacheManager(){
		return "sys/cache/init";
	}
	
	
	
	
	

}
