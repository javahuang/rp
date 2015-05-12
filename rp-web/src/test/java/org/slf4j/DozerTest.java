/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.slf4j;

import org.apache.tools.ant.types.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.domains.SourceBean;
import org.slf4j.domains.TargetBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 可以进行bean之间的映射
 * 直接映射或者集成spring
 * dozer会对Mapping注解的bean或者相同名称的字段进行映射
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月14日 下午8:53:16
 * <p>Version: 1.0
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:dozer/test-dozer.xml")
public class DozerTest {
//	@Autowired
//	DozerBeanMapper mapper;
	
	//@Test
	public void mappintViaAnnocationTest() throws Exception{
		//Mapper mapper = new DozerBeanMapper();
		SourceBean source=new SourceBean();
		source.setData("测试");
		source.setName("小明");
		source.setId(123456l);
//		TargetBean destObject =  mapper.map(source, TargetBean.class);
//		System.out.println(destObject.getName());
//		System.out.println(destObject.getBinaryData());//测试
	}

}
