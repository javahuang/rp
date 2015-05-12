/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.lang;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * org.apache.commons.lang3包提供了一些很有意思的工具类
 * <p/>
 * <p>http://blog.csdn.net/lonely_fireworks/article/details/7962171
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年5月8日 上午9:50:00
 * <p>
 * Version: 1.0
 */
public class StringTest {

	// @Test
	public void test1() {
		// 比如可以通过这个获取文件后缀
		System.out.println(StringUtils.substringAfterLast("test.test2.3.png",
				"."));
	}

	public void test2() {
		String str = null;
		/*
		 * %n换行 %s字符串类型 %c字符类型 %b布尔类型
		 * %d整数类型(十进制) %x整数类型(十六进制) %o整数类型(8进制)
		 * %f浮点类型
		 * %%百分比类型
		 */
		str = String.format("Hi,%s", "王力");
		System.out.println(str);// 字符串 s%
		str = String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
		System.out.println(str);
		System.out.printf("字母a的大写是：%c %n", 'A');
		System.out.printf("3>7的结果是：%b %n", 3 > 7);
		System.out.printf("100的一半是：%d %n", 100 / 2);
		System.out.printf("100的16进制数是：%x %n", 100);
		System.out.printf("100的8进制数是：%o %n", 100);
		System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
		System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
		System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
		System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
		System.out.printf("上面的折扣是%d%% %n", 85);
		System.out.printf("字母A的散列码是：%h %n", 'A');
	}

	public void test3() {
		String str = null;
		// $使用 被格式化的参数索引
		str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");
		System.out.println(str);
		// +使用
		System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);
		// 补O使用
		System.out.printf("最牛的编号是：%03d%n", 7);//007
		// 空格使用
		System.out.printf("Tab键的效果是：% 8d%n", 7);//       7
		// .使用
		System.out.printf("整数分组的效果是：%,d%n", 9989997);//9,989,997
		// 空格和小数点后面个数
		System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);//一本书的价格是：                                          49.80000元
	}
	/**
	 * 日期和事件字符串格式化
	 */
	@Test
	public void test4(){
		   Date date=new Date();                                
		    //c的使用 星期五 五月 08 21:03:48 CST 2015
		    System.out.printf("全部日期和时间信息：%tc%n",date);        
		    //f的使用 2015-05-08
		    System.out.printf("年-月-日格式：%tF%n",date);
		    //d的使用 05/08/15
		    System.out.printf("月/日/年格式：%tD%n",date);
		    //r的使用 09:03:48 下午
		    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
		    //t的使用 21:03:48
		    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
		    //R的使用 21:03
		    System.out.printf("HH:MM格式（24时制）：%tR",date);
	}

}
