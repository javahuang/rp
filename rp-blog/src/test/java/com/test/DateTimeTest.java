/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.test;

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月19日 下午6:34:09
 * <p>Version: 1.0
 */
public class DateTimeTest {
	
	@Test
	public void test(){
		Date d=new Date(115, 4, 19);
		DateTime dt=new DateTime(d.getTime());
		System.out.println(dt.monthOfYear().getAsText(Locale.ENGLISH));//得到2015
	}

}
