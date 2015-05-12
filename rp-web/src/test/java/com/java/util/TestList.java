/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.java.util;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月11日 下午9:17:15
 * <p>Version: 1.0
 */
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class TestList {

	
	/**
	 * @param first
	 * @param second
	 * @param rest
	 * @return
	 */
	public static Iterable<Object> iterable(final Object first, final Object second,
			final Object[] rest) {
		return new AbstractList<Object>() {
			@Override
			public Object get(int index) {
				switch (index) {
				case 0:
					return first;
				case 1:
					return second;
				default:
					return rest[index - 2];
				}
			}
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return rest.length + 2;
			}
		};

	}
	@Test
	public void test(){
		String s1="小明";
		String s2="小黑";
		String s3="小强";
		Iterable<Object> it=iterable(s1,s2,new String[]{s3});
		List<String>l=new ArrayList<String>();
		l.add(s1);l.add(s2);l.add(s3);
		long start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			it.iterator().next();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			l.get(0);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	

	// 下面是时间复杂度测试
	public static final int N = 50000;

	public static List values;

	static {
		Integer vals[] = new Integer[N];

		Random r = new Random();

		for (int i = 0, currval = 0; i < N; i++) {
			vals[i] = new Integer(currval);
			currval += r.nextInt(100) + 1;
		}

		values = Arrays.asList(vals);
	}

	static long timeList(List lst) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			int index = Collections.binarySearch(lst, values.get(i));
			if (index != i)
				System.out.println("***错误***");
		}
		return System.currentTimeMillis() - start;
	}

	/**
	 * 通过测试 arraylist 对于随机读取 arraylist快
	 * 1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
	 * 2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。
	 * 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("ArrayList消耗时间：" + timeList(new ArrayList(values)));
		System.out
				.println("LinkedList消耗时间：" + timeList(new LinkedList(values)));

		System.out.println("ArrayList消耗时间：" + timeList1(new ArrayList(values)));
		System.out.println("LinkedList消耗时间："
				+ timeList1(new LinkedList(values)));
	}

	static long timeList1(List list) {
		long start = System.currentTimeMillis();
		Object o = new Object();
		for (int i = 0; i < N; i++)
			list.add(0, o);
		return System.currentTimeMillis() - start;
	}

	/*
	 * ArrayList和LinkedList在性能上各有优缺点，都有各自所适用的地方，总的说来可以描述如下：
	 * 1．对ArrayList和LinkedList而言
	 * ，在列表末尾增加一个元素所花的开销都是固定的。对ArrayList而言，主要是在内部数组中增加一项
	 * ，指向所添加的元素，偶尔可能会导致对数组重新进行分配；而对LinkedList而言，这个开销是统一的，分配一个内部Entry对象。
	 * 
	 * 2．在ArrayList的中间插入或删除一个元素意味着这个列表中剩余的元素都会被移动；而在LinkedList的中间插入或删除一个元素的开销是固定的
	 * 
	 * 3．LinkedList不支持高效的随机元素访问。
	 * 
	 * 4．ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，
	 * 而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间
	 * 
	 * 可以这样说：当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用ArrayList会提供比较好的性能；
	 * 当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用LinkedList了。
	 */
}
