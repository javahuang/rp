/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月9日 下午11:56:26
 * <p>Version: 1.0
 */
public class PatternUtils {
	
	/**电话正则表达式*/
	public static final String telephoneRegex="^(13\\d|15\\d|18\\d)\\d{8}$";
	/**邮箱正则表达式*/
	public static final String emailRegex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
	/**
	 * 检查字符串是否匹配对应的正则
	 * @param str
	 * @return
	 */
	public static boolean matches(String str,final String regex){
		if(StringUtils.isBlank(str)||StringUtils.isBlank(regex))
			return false;
		Pattern pat=Pattern.compile(regex);
		Matcher mat=pat.matcher(str);
		return mat.matches();
	}
}
