/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.lang;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月8日 下午4:33:43
 * <p>Version: 1.0
 */
public class NumberTest {
	
	/*
	 * DecimalFormat 类主要靠 # 和 0 两种占位符号来指定数字长度。
	 * 0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置
	 * 
	 * 对于数值的转化需要转化为double类型
	 * 如1/3 得到0  1/3.0得到0.3333..
	 * */
	@Test
	public void test1(){
		//将数字转化为百分比
		DecimalFormat df=new DecimalFormat("0000000.00%");
		DecimalFormat df1=new DecimalFormat("#######.00%");
		System.out.println(df.format(1003.4567));//0100345.67%
		System.out.println(df1.format(1003.4567));//100345.67%
		System.out.println(new DecimalFormat("光速大小为每秒,###米。").format(1234)); //光速大小为每秒1,234米。 
	}

}
