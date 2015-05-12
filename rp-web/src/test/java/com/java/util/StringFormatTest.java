/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.java.util;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

import org.junit.Test;

/**
 * 字符串的格式化输出
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月12日 下午5:01:07
 * <p>
 * Version: 1.0
 */
public class StringFormatTest {

	// String.format("%03d",Integer.parseInt(version));
	/**
	 * 常规类型/数值类型/字符类型格式化  %[argument_index$][flags][width][.precision]conversion  
	 * 日期类型 %[argument_index$][flags][width]conversion  
	 * 与参数不对应格式说明符 %[flags][width]conversion  
	 * argument_index  参数在参数列表中的位置。第一个参数由 "1$" 引用，第二个参数由 "2$" 引用
	 * flags 是修改输出格式的字符集。有效标志集取决于转换类型
	 * width 是一个非负十进制整数，表明要向输出中写入的最少字符数
	 * precision 是一个非负十进制整数，通常用来限制字符数。特定行为取决于转换类型
	 * conversion 是一个表明应该如何格式化参数的字符。给定参数的有效转换集取决于参数的数据类型。
	 */
	@Test
	public void test1() {
		Calendar c = Calendar.getInstance();
		String s1 = String.format("今天是：%1$tY年%1$tm月%1$te日", c);
		String s2 = String.format("今天是：%1$tY年%<tm月%<te日", c);
		System.out.println(s1 + " " + s2);
		System.out.format("%S","teSt");//将结果转化为大写
		System.out.format("%n","");//n换行
		//下面这个格式是 %[flags][width]conversion 
		System.out.format("%03d", 12);//012 'd'	整数	结果被格式化为十进制整数
		System.out.format("%n","");//n换行
		System.out.format("%2$s %s %<s %s", "a", "b", "c", "d"); //输出是baab  涉及到索引
		System.out.format("%+2d",12);//
	}
	/*flag
	 * 标志	常规	字符	整数	浮点	日期/时间	说明s
	 * '-'	y	y	y	y	y	结果将是左对齐的。
	   '#'	y1	-	y3	y	-	结果应该使用依赖于转换类型的替换形式
       '+'	-	-	y4	y	-	结果总是包括一个符号
       '  '	-	-	y4	y	-	对于正值，结果中将包括一个前导空格
       '0'	-	-	y	y	-	结果将用零来填充
       ','	-	-	y2	y5	-	结果将包括特定于语言环境的组分隔符
       '('	-	-	y4	y5	-	结果将是用圆括号括起来的负数
	  * */
	/*conversion  
	 *'d'	整数	结果被格式化为十进制整数
	 *'f'	浮点	结果被格式化为十进制数
	 *'%'	百分比	结果为字面值 '%' ('\u0025') 
	 *'s', 'S'	结果为调用 arg.toString() 得到的结果 大写S相当于toUpperCase()
	 **/
}
