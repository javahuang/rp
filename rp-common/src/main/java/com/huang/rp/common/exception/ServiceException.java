/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.exception;

import java.util.Map;

/**
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月23日 下午12:28:24
 * <p>
 * Version: 1.0
 */
public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;
	private String redirect;//重定向页面
	private Map<String, Object> params;

	/**
	 * @param defaultMessage
	 */
	public ServiceException(String redirect) {
		this.redirect = redirect;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
