/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.springframework.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * http://stackoverflow.com/questions/7542506/spring-
 * propertyplaceholderconfigurer-and-contextproperty-placeholder
 * 上面在so上找到了一片回答介绍<util <context:property-placeholder 这两种方式的区别
 *
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月10日 下午12:03:03
 * <p>
 * Version: 1.0
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/util-context/applicationContext-util.xml")
public class UtilContextTagTest {
	// 这个地方使用了spel表达式 注入的name是不需要set和get方法的 引用<util:properties
	@Value(value = "#{testConfig['name']}")
	String name;
	// 引用<util:list
	@Value(value = "#{emailsList}")
	// 获取定义的list
	List emailsList;

	@Value(value = "${age}")
	Integer age;

	//@Test
	public void test1() {
		System.out.println(name);
		System.out.println(emailsList.size());
		System.out.println(age);
	}

}
