/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.web.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年5月6日 下午9:13:54
 * <p>
 * Version: 1.0
 */
public abstract class BaseController {

	private String viewPrefix;

	protected BaseController() {
		setViewPrefix(defaultViewPrefix());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String init() {
		return viewName("init");
	}

	/**
	 * 设置通用数据
	 *
	 * @param model
	 */
	protected void setCommonData(Model model) {
	}

	/**
	 * 当前模块 视图的前缀 默认 1、获取当前类头上的@RequestMapping中的value作为前缀 2、如果没有就使用当前模型小写的简单类名
	 */
	public void setViewPrefix(String viewPrefix) {
		if (viewPrefix.startsWith("/")) {
			viewPrefix = viewPrefix.substring(1);
		}
		this.viewPrefix = viewPrefix;
	}

	public String getViewPrefix() {
		return viewPrefix;
	}

	/**
	 * 获取视图名称：即prefixViewName + "/" + suffixName
	 *
	 * @return
	 */
	public String viewName(String suffixName) {
		if (!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}
		return getViewPrefix() + suffixName;
	}

	/**
	 * @param backURL
	 *            null 将重定向到默认getViewPrefix()
	 * @return
	 */
	protected String redirectToUrl(String backURL) {
		if (StringUtils.isEmpty(backURL)) {
			backURL = getViewPrefix();
		}
		if (!backURL.startsWith("/") && !backURL.startsWith("http")) {
			backURL = "/" + backURL;
		}
		return "redirect:" + backURL;
	}

	protected String defaultViewPrefix() {
		String currentViewPrefix = "";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(
				getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			currentViewPrefix = requestMapping.value()[0];
		}

		return currentViewPrefix;
	}

}
