/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.joda;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月7日 下午11:18:29
 * <p>Version: 1.0
 */
public class TimeTest {
	
	@Test
	public void test1(){
		DateTime dt=new DateTime();
		System.out.println(dt.getYear()+dt.getMonthOfYear());
	}

}
