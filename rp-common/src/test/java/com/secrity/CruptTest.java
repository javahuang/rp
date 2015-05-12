/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.secrity;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

/**
 * 加密解密测试类
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月8日 上午9:32:52
 * <p>Version: 1.0
 */
public class CruptTest {
	
	public void test1(){
		URLCodec uc=new URLCodec();
		try {
			//用途,比如在网页后面带上重定向的url localhost:8080/test?referurl=http%3A%2F%2Fwww.baidu.com%3Fa%3D1%26b%3D2
			System.out.println(uc.encode("http://www.baidu.com?a=1&b=2"));//http%3A%2F%2Fwww.baidu.com%3Fa%3D1%26b%3D2
			try {
				System.out.println(uc.decode("http%3A%2F%2Fwww.baidu.com%3Fa%3D1%26b%3D2"));
			} catch (DecoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		Base64 b=new Base64();
		try {
			Md5Crypt md5=new Md5Crypt();
			System.out.println(md5.apr1Crypt("1111111"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
