/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.rbac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huang.rp.sys.rbac.domain.SysUser;
import com.huang.rp.web.sys.rbac.authentication.MyFormAuthenticationFilter;
import com.huang.rp.web.sys.rbac.service.RbacService;

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
	
	@Autowired
	RbacService rbacService;
	@Autowired
	MyFormAuthenticationFilter authcFilter;
	
	/**
	 * get不会走拦截器
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "index";
	}
	
	@RequestMapping(value = {"/{index:index;?.*}"}) //可能出现jessionid匹配的情况
    public String index(Model model) {
//        List<SysResource> menus = sysResourceService.findMenus(user);
//        model.addAttribute("menus", menus);
        return "index";
    }
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("regist")
	@ResponseBody
	public String regist(SysUser user,HttpServletResponse response,HttpServletRequest request){
		try{
			/**目前不开放注册操作*/
			rbacService.addUser(user);
			//注册完毕执行登录操作
			authcFilter.executeLogin(request, response);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}

}
