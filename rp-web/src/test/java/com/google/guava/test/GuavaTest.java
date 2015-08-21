/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.google.guava.test;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import sun.security.provider.certpath.Vertex;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.base.Throwables;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Table;
import com.google.common.collect.TreeMultiset;
import com.google.common.primitives.Ints;

/**
 * guava很多方法都是遵循Fluent接口风格,即类似java中的builder模式
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月11日 下午8:08:20
 * <p>
 * Version: 1.0
 */
public class GuavaTest {

	// @Test
	public void functionTest() {
		Map<String, Double> map1 = Maps.newHashMap();
		map1.put("computer", 2121.22);
		map1.put("camera", 222.22);
		@SuppressWarnings("unchecked")
		Map map2 = Maps.transformValues(map1, new Function() {
			double m = 1000;

			public Double apply(final double from) {
				// TODO Auto-generated method stub
				return from * m;
			}

			@Override
			public Object apply(Object arg0) {
				// TODO Auto-generated method stub
				return null;
			}

		});
	}
	@Test
	public void splitter(){
		List<String>strs=Lists.newArrayList(Splitter.on(",").limit(2).split("A,B,C,d"));
		System.out.println(strs);//[A, B,C,d]
		//忽略空字符串
		Splitter.on(",").limit(4).omitEmptyStrings().split("A,V,,,,C,D");
		Splitter.on(";").trimResults().withKeyValueSeparator("=").split("a=2;b=3");
	}
	// @Test
	public void joiner() {
		// 字符串拼接
		String s1 = Joiner.on(' ').join(1, 2, 3, 4);
		System.out.println(s1);// 1 2 3 4
		StringBuilder sb = new StringBuilder();
		Joiner.on(" ").appendTo(sb, 6, 7, 8);
		System.out.println(sb);// 6 7 8
		// 跳过空值 将空值替换为别的值
		String s2 = Joiner.on(' ').skipNulls().join(1, null, 3);// 1 3
		String s3 = Joiner.on(' ').useForNull("None").join(1, null, 3);// 1 None
																		// 3
		System.out.println(s2);
		System.out.println(s3);
		// withKeyValueSeparator 方法指定了键与值的分隔符，同时返回一个 MapJoiner 实例
		Joiner.on("#").withKeyValueSeparator("=")
				.join(ImmutableMap.of(1, 2, 3, 4));
		// △将if和while配合使用迭代Iterator用制定字符拼接字符串,避免拼接后末尾添加该字符

	}

	// @Test//使用和避免null
	public void nullTest() {
		Optional<Integer> possible = Optional.of(1);// 创建指定引用的实例 如果null则NPE
		possible.isPresent(); // if contain non-null returns true
		System.out.println(possible.get());// returns 1
		Optional.fromNullable(null).or("default value");// 如果是null则返回默认值
	}

	// @Test//前置条件测试
	public void preconditionsTest() {
		int a = 1;
		checkArgument(a != 1, "Argument was %s but expected %s", 100, a);
		// checkElementIndex(int index, int size);
		// checkPositionIndexes(int start, int end, int size);
	}

	// @Test//
	public void objectsTest() {
		Objects.equal("a", "a"); // returns true
		Objects.equal(null, "a"); // returns false
		Objects.equal("a", null); // returns false
		Objects.equal(null, null); // returns true
		Objects.toStringHelper("MyObject").add("x", 1).toString();// MyObject{x=1}
		// Returns "ClassName{x=1}"
		Objects.toStringHelper(this).add("x", 1).toString();
	}

	// @Test
	// 排序器
	public void conpareTest() {
		People p1 = new People().setAge(2).setName("小明");
		People p2 = new People().setAge(3).setName("小明");
		ComparisonChain.start().compare(p1.getName(), p2.getName())
				.compare(p1.getAge(), p2.getAge());
		// 对可排序类型做自然排序，如数字按大小，日期按先后排序
		System.out.println(Ordering.natural().max(3, 2));// Ordering.natural()
															// 由静态方法创建排序器
		// 按对象的字符串形式做字典排序[lexicographical ordering]
		System.out.println(Ordering.usingToString().max("afg", "afx"));
		// from(Comparator)

		// 自定义排序器
		Ordering<String> byLengthOrdering = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};

		Ordering.natural().reverse().nullsFirst();
		// 排序器首先调用apply方法获取sortedBy值，并把sortedBy为null的元素都放到最前面，然后把剩下的元素按sortedBy进行自然排序。
		Ordering<People> ordering = Ordering.natural().nullsFirst()
				.onResultOf(new Function<People, String>() {
					public String apply(People foo) {
						return foo.getName();
					}
				});

	}

	// @Test//异常处理
	public void throwableTest() {
		// Throwables.propagate 类似于java7的多重捕获异常
		// } catch (RuntimeException | Error e) {//java7的多重捕获异常
		// failures.increment();
		// throw e;
		// }
		Throwable t = new Throwable();
		Throwables.propagate(t);// 果Throwable是Error或RuntimeException，直接抛出；否则把Throwable包装成RuntimeException抛出。
		// 抛出制定类型异常
		// Throwables.propagateIfInstanceOf(throwable, declaredType);

	}

	// @Test //不可变集合
	public void immutableCollectionTest() {
		// 不可变集合 不存在竞态条件,线程安全 不可变集合不需要考虑变化，因此可以节省时间和空间
		// Collections.unmodifiableCollection(c)//jdk提供的创建的不可变集合
		ImmutableSet.of("a", "c");

		ImmutableSet<String> foobar = ImmutableSet.of("foo", "bar", "baz");
		// ImmutableXXX.copyOf(ImmutableCollection)会试图对如下情况避免线性时间拷贝
		ImmutableList<String> defensiveCopy = ImmutableList.copyOf(foobar);// ImmutableSet的常量时间复杂度的List视图。
		ImmutableSortedSet.copyOf(foobar).asList();// [bar, baz,
													// foo]//所有不可变集合都有一个asList()方法提供ImmutableList视图
	}

	@Test
	// 集合 http://ifeve.com/google-guava-newcollectiontypes/
	public void collectionTest() {
		// Multiset 没有元素顺序限制的ArrayList<E>;Map<E, Integer>，键为元素，值为计数
		Multiset<Integer> s = TreeMultiset.create();
		s.add(1);
		s.add(1);
		s.add(2);
		System.out.println(s.count(1));// 2
										// HashMultiset.count的复杂度为O(1)，TreeMultiset.count的复杂度为O(log
										// n)。
		// **Multiset.addAll(Collection)可以添加Collection中的所有元素并进行计数
		// 实现 ImmutableMultiset ConcurrentHashMultiset LinkedHashMultiset
		// TreeMultiset HashMultiset
		// **Multimap 键-值集合映射”的映射： a -> [1, 2, 4] b -> 3 c -> 5
		// Multimap.get(key)总是返回非null、但是可能空的集合。这并不意味着Multimap为相应的键花费内存创建了集合，而只是提供一个集合视图方便你为键增加映射值
		// 实现 ArrayListMultimap HashMultimap 等
		// Multimap<K, V> multimap = LinkedListMultimap.create();
		// multimap.put(key1, foo);
		// multimap.put(key2, bar);
		// multimap.put(key1, baz);
		// **BiMap 可以用 inverse()反转BiMap<K, V>的键值映射
		// 实现 HashBiMap ImmutableBiMap EnumBiMap EnumHashBiMap
		// Maps.synchronizedBiMap(bimap);//返回一个线程安全的biMap
		BiMap<String, Integer> userId = HashBiMap.create();
		// ** Table 使用多个键做索引的时候
		Table<Vertex, Vertex, Double> weightedGraph = HashBasedTable.create();
		// weightedGraph.put(v1, v2, 4);
		// weightedGraph.put(v1, v3, 20);
		// weightedGraph.put(v2, v3, 5);
		// weightedGraph.row(v1); // returns a Map mapping v2 to 4, v3 to 20
		// weightedGraph.column(v3); // returns a Map mapping v1 to 20, v2 to 5
		// **ClassToInstanceMap 它的键是类型，而值是符合键所指类型的对象。
		// 实现 MutableClassToInstanceMap/ImmutableClassToInstanceMap
		ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap
				.create();
		numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
		// **RangeSet
		// **RangeMap
		
		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		Map<String, Integer> right = ImmutableMap.of("a", 4, "b", 2, "d", 6);
		MapDifference<String, Integer> diff = Maps.difference(left, right);
		diff.entriesInCommon(); // {"b" => 2}
		diff.entriesInCommon(); // {"b" => 2}
		diff.entriesOnlyOnLeft(); // {"a" => 1}
		diff.entriesOnlyOnRight(); // {"d" => 5}

	}
}

class People {
	private String name;
	private int age;
	private Date birthday;

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
	public People setName(String name) {
		this.name = name;
		return this;
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
	public People setAge(int age) {
		this.age = age;
		return this;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
