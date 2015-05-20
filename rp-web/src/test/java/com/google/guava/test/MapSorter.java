/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.google.guava.test;

/**
 * 可重复键的map排序
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月19日 下午9:24:57
 * <p>Version: 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.guava.test.KeyValueComparator.Order;
import com.google.guava.test.KeyValueComparator.Type;


public class MapSorter {

	public static void main(String[] args) {
		IdentityHashMap<Double, String> map = new IdentityHashMap<Double, String>();
		map.put(10.1, "aaaa");
		map.put(10.1, "bbbb");
		map.put(10.1, "cccc");
		map.put(10.08, "dddd");
		map.put(10.02, "eeee");
		map.put(10.08, "aaaa");

		System.out.println("----------[ [ [ 排序前  ] ] ]----------\n");

		for (Entry<Double, String> entry : map.entrySet()) {
			System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());
		}

		System.out.println("\n----------[ [ [ 按键降序 ] ] ]----------\n");

		List<Map.Entry<Double, String>> list1 = new ArrayList<Map.Entry<Double, String>>(map.entrySet());
		Collections.sort(list1, new KeyValueComparator(Type.KEY, Order.DESC));

		for (Entry<Double, String> entry : list1) {
			System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());
		}
		
		System.out.println("\n----------[ [ [ 按值升序  ] ] ]----------\n");
		
		List<Map.Entry<Double, String>> list2 = new ArrayList<Map.Entry<Double, String>>(map.entrySet());
		Collections.sort(list2, new KeyValueComparator(Type.VALUE, Order.ASC));

		for (Entry<Double, String> entry : list2) {
			System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());
		}

		System.out.println("\n----------[ [ [ 结束啦 ] ] ]----------\n");
	}
}

class KeyValueComparator implements Comparator<Map.Entry<Double, String>> {
	enum Type {
		KEY, VALUE;
	}

	enum Order {
		ASC, DESC
	}

	private Type type;
	private Order order;

	public KeyValueComparator(Type type, Order order) {
		this.type = type;
		this.order = order;
	}

	@Override
	public int compare(Entry<Double, String> o1, Entry<Double, String> o2) {
		switch (type) {
		case KEY:
			switch (order) {
			case ASC:
				return o1.getKey().compareTo(o2.getKey());
			case DESC:
				return o2.getKey().compareTo(o1.getKey());
			default:
				throw new RuntimeException("顺序参数错误");
			}
		case VALUE:
			switch (order) {
			case ASC:
				return o1.getValue().compareTo(o2.getValue());
			case DESC:
				return o2.getValue().compareTo(o1.getValue());
			default:
				throw new RuntimeException("顺序参数错误");
			}
		default:
			throw new RuntimeException("类型参数错误");
		}
	}

}

