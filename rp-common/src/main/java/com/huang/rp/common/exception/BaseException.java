/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.exception;

import org.apache.commons.lang3.StringUtils;

import com.huang.rp.common.utils.MessageUtils;

/**
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月21日 下午12:17:11
 * <p>
 * Version: 1.0
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 所属模块
	private String module;

	/**
	 * 错误码
	 */
	private String code;

	/**
	 * 错误码对应的参数
	 */
	private Object[] args;

	/**
	 * 错误消息
	 */
	private String defaultMessage;

	public BaseException(String module, String code, Object[] args,
			String defaultMessage) {
		this.module = module;
		this.code = code;
		this.args = args;
		this.defaultMessage = defaultMessage;
	}

	public BaseException(String module, String code, Object[] args) {
		this(module, code, args, null);
	}

	public BaseException(String module, String defaultMessage) {
		this(module, null, null, defaultMessage);
	}

	public BaseException(String code, Object[] args) {
		this(null, code, args, null);
	}

	public BaseException(String defaultMessage) {
		this(null, null, null, defaultMessage);
	}
	
	public BaseException(){
		this(null,null,null,null);
	}

	@Override
	public String getMessage() {
		String message = null;
		if (!StringUtils.isEmpty(code)) {
			message = MessageUtils.message(code, args);
		}
		if (message == null) {
			message = defaultMessage;
		}
		return message;
	}

	public String getModule() {
		return module;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	@Override
	public String toString() {
		return this.getClass() + "{" + "module='" + module + '\''
				+ ", message='" + getMessage() + '\'' + '}';
	}

}
