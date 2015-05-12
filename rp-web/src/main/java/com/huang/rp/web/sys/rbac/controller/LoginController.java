/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录逻辑都是在authc shiro过滤器里面执行的
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年5月9日 下午11:30:02
 * <p>
 * Version: 1.0
 */
@Controller
public class LoginController {
	
	/**
	 * get不会走拦截器
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "index";
	}

}
