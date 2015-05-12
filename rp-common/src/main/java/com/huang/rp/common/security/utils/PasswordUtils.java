/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.security.utils;

import com.huang.rp.common.utils.Encodes;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月8日 下午9:19:40
 * <p>Version: 1.0
 */
public class PasswordUtils {


	/***
	 * 获取随即的八位字符的byte数组
	 * 
	 * @return
	 */
	public static byte[] getSaltBytes() {
		return Digests.generateSalt(8);
	}

	/***
	 * 获取随即的指定位数位字符的byte数组
	 * 
	 * @return
	 */
	public static byte[] getSaltBytes(int num) {
		return Digests.generateSalt(num);
	}

	/***
	 * 获取指定字符的字节
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		return str.getBytes();
	}

	/**
	 * Hex加密算法
	 * 
	 * @param salts
	 * @return
	 */
	public static String encodeHex(byte[] bytes) {
		return Encodes.encodeHex(bytes);
	}

	/**
	 * Hex解密算法
	 */
	public static byte[] decodeHex(String input) {
		return Encodes.decodeHex(input);
	}

	/***
	 * 获取“关键词”加密字符
	 * 
	 * @param salts
	 * @return
	 */
	public static String getEncodeSalts(byte[] salts) {
		return encodeHex(salts);
	}

	/***
	 * 本系统中密码生产器
	 * 
	 * @param passWord
	 *            <String>未加密
	 * @param salts
	 *            <byte[]>未加密
	 * @return
	 */
	public static String getEncodePassWord(String passWord, byte[] salts) {
		byte[] hashPassword = Digests.sha1(getBytes(passWord), salts, 1024);
		return encodeHex(hashPassword);
	}
}
