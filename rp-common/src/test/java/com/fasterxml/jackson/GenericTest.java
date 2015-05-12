/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.fasterxml.jackson;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型实体可以随便创建 无需使用泛型
 * 但是当第一次向T设值时,之后就只能使用该值?
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月21日 下午8:45:17
 * <p>
 * Version: 1.0
 */
public class GenericTest {
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

	public <T> void setFavorite(Class<T> klass, T thing) {
		favorites.put(klass, thing);
	}

	public <T> T getFavorite(Class<T> klass) {
		return klass.cast(favorites.get(klass));
	}

	public static void main(String[] args) {
		GenericTest f = new GenericTest();
		f.setFavorite(String.class, "Java");
		f.setFavorite(Integer.class, 0xcafebabe);
		String s = f.getFavorite(String.class);
		int i = f.getFavorite(Integer.class);
		System.out.println(s);
		System.out.println(new Integer(i).toHexString(i));
	}

}
