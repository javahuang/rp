/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.huang.rp.common.Constants;

/**
 * 向ctx设置值
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月23日 下午3:33:49
 * <p>Version: 1.0
 */
public class SetCommonDataInterceptor extends HandlerInterceptorAdapter{

	/**
	 * 该方法将在Controller处理之前进行调用
	 * return false的话拦截器就中断
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if(request.getAttribute(Constants.WEB_CONTEXT)==null){
			request.setAttribute(Constants.WEB_CONTEXT, request.getContextPath());
		}
		return super.preHandle(request, response, handler);
	}
	/**
	 * 在处理器进行处理之 后，也就是在Controller的方法调用之后执行，
	 * 但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 作。
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * preHandle方法返回值为true的时候才会执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	

}
