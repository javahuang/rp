/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.springframework.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
//@ContextConfiguration("/cache/applicationContext-ehcache.xml")
public class EhcacheSpringTest {

	@Autowired
	CacheManager cacheManager;

	//@Test
	public void test1() {
		Cache sysCache = cacheManager.getCache("sysCache");
		sysCache.put("bane", "小明");
		System.out.println(sysCache.get("bane", String.class));
	}

	/**
	 * 如果id<10 则查缓存
	 * 
	 * @param id
	 * @return
	 */
	@Cacheable(value = "user", key = "#id", condition = "#id lt 10")
	public User conditionFindById(final Long id) {
		return new User();
	}

	/**
	 * 如果结果的username不是zhang的时候放入缓存 ne是not equal
	 * 
	 * @param user
	 * @return
	 */
	@CachePut(value = "user", key = "#id", condition = "#result.username ne 'zhang'")
	public User conditionSave(final User user) {
		return new User();
	}

	/**
	 * 如果结果的username不是zhang的时候放入缓存
	 * 
	 * @param user
	 * @return
	 */
	@CachePut(value = "user", key = "#user.id", unless = "#result.username eq 'zhang'")
	public User conditionSave2(final User user) {
		return null;
	}

	/**
	 * beforeInvocation 表示在方法执行之后调用 condition为true 则移除缓存
	 * 
	 * @param user
	 * @return
	 */
	@CacheEvict(value = "user", key = "#user.id", beforeInvocation = false, condition = "#result.username ne 'zhang'")
	public User conditionDelete(final User user) {
		return null;
	}
	/**
	 * 放入多个缓存
	 * @param user
	 * @return
	 */
	@Caching(put = { @CachePut(value = "user", key = "#user.id"),
			@CachePut(value = "user", key = "#user.username"),
			@CachePut(value = "user", key = "#user.email") })
	public User save(User user) {
		return null;
	}
}

class User {

	private String name;
	private int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
