/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.fasterxml.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;

/**
 * 基于jackson的一些测试
 * <p/>
 * springMVC spring-webmvc依赖jackson包
 * @Responsebody 默认使用了MappingJackson2JsonView作为视图解析
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月21日 下午8:09:27
 * <p>
 * Version: 1.0
 */
public class JacksonTest {

	/**
	 * jackson的read and write
	 */
	// @Test
	public void test1() {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		try {
			// 这里有个疑问,我目前还真的不知道json在文件中应该以什么格式保存?
			// 上面这个问题在下面得到验证 json格式是 {"name":"Bob","age":13} 字符串必须加双引号
			// 直接new File(path) 这个path是相对于目前eclipse项目根目录路径下面,非class根目录
			// mapper.readValue(new File("c:/test.json"), MyValue.class);

			// to enable standard indentation ("pretty-printing"):
			mapper.enable(SerializationFeature.INDENT_OUTPUT);// 设置之后,输出的json会格式化
			MyValue value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}",
					MyValue.class);
			mapper.writeValue(new File("result.json"), value);
			/** 简单类型的map可以直接使用如下方法 */
			// Map<String, Integer> scoreByName =
			// mapper.readValue(jsonSource,Map.class);
			// List<String> names = mapper.readValue(jsonSource, List.class);
			/**
			 * as long as JSON structure matches, and types are simple. If you
			 * have POJO values, you need to indicate actual type (note: this is
			 * NOT needed for POJO properties with List etc types):
			 */
			/** 带泛型的map需要使用TypeReference 关于TypeReference可以参见TypeReference那个demo */
			Map<String, MyValue> results = mapper.readValue(
					"{\"test\":{\"name\":\"Bob\", \"age\":13}}",
					new TypeReference<Map<String, MyValue>>() {
					});// 得到key为test value为MyValue的对象
			// {"name":"Bob","age":13,"other":{"type":"student"}}
			JsonNode root = mapper.readTree(new File("result1.json"));
			System.out.println("name:" + root.get("name").asText());
			System.out.println(root.get("age"));
			System.out.println(root.get("other").get("type").asText());// student
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * two entry-level configuration mechanisms you are likely to use: Features
	 * and Annotations. 数据绑定
	 */
	// @Test
	public void test2() {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		ObjectReader o = mapper.reader();

		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// Both Serialization and Deserialization features may
		// 定义了序列化和反序列化时候的一些机制
		ObjectWriter w = mapper.writer(SerializationFeature.WRAP_ROOT_VALUE);
		ObjectWriter w2 = w
				.without(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		ObjectReader r = mapper
				.reader(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
		ObjectReader r2 = r.with(
				DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY).without(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// Most databind features do NOT affect Tree Model (JsonNode)
		// since Tree Model is meant to be 1-to-1 representation of underlying
		// physical content, and as such, minimal amount of converting is done
		// on purpose.
	}

	/**
	 * These features determine if and how canonicalization of JSON Object
	 * property names is done. 这个暂时还不知道怎么使用 JsonFactory-Features
	 * https://github.com/FasterXML/jackson-core/wiki/JsonFactory-Features
	 * Streaming API features Features configurable via ObjectMapper,
	 * ObjectWriter and ObjectReader are divide into two main categories:
	 * high-level settings that affect jackson-databind components directly; and
	 * low-level settings that affect behavior of Streaming API behavior
	 * (JsonParser, JsonGenerator). 下面演示的主要是基于stream的api 包含 Factory
	 * feature,Generator features,Parser features
	 */
	// @Test
	public void test3() {
		JsonFactory f = new JsonFactory();
		f.disable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);

		f.enable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
		f.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
		// JsonGenerator g = f.createGenerator();
		f.enable(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION);
	}

	/**
	 * Annotations test fancier stuff, conversions
	 * 
	 */
	@Test
	public void test4() {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.enable(SerializationFeature.INDENT_OUTPUT);// 设置之后,输出的json会格式化

		MyValue value;
		try {
			value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}",
					MyValue.class);
			mapper.writeValue(new File("result.json"), value);

			// Conversions work between any compatible types, and invocation is
			// as simple as:
			CtorBean cb = mapper.convertValue(value, CtorBean.class);
			System.out.println(cb.getName());

			// Convert from int[] to List<Integer>
			List<Integer> sourceList = Lists.newArrayList();
			sourceList.add(1);
			sourceList.add(2);
			int[] ints = mapper.convertValue(sourceList, int[].class);
			// Convert a POJO into Map!
			// Map<String,Object> propertyMap = mapper.convertValue(pojoValue,
			// Map.class);
			// ... and back
			// PojoType pojo = mapper.convertValue(propertyMap, PojoType.class);
			// decode Base64! (default byte[] representation is base64-encoded
			// String)
			String base64 = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz";
			byte[] binary = mapper.convertValue(base64, byte[].class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test5() {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		//Include.Include.ALWAYS 默认  
		//Include.NON_DEFAULT 属性为默认值不序列化  
		//Include.NON_EMPTY 属性为 空（“”）  或者为 NULL 都不序列化  
		//Include.NON_NULL 属性为NULL 不序列化  
		//Method for setting defalt POJO property inclusion strategy for serialization.
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		//mapper.setBase64Variant(v)
	}
	
	public void test6(){
		 ObjectMapper objectMapper = new ObjectMapper();
		 MyValue loginRes = null;
		 String loginresp=null;
         try {
            objectMapper
                  .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);//序列化字符串中未知的key不会报错
            // objectMapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
            // objectMapper.disable(SerializationFeature.)
            loginRes = objectMapper.readValue(loginresp, MyValue.class);
         } catch (JsonParseException e2) {
            e2.printStackTrace();
         } catch (JsonMappingException e2) {
            e2.printStackTrace();
         } catch (IOException e2) {
            e2.printStackTrace();
         }
	}

}

// @JsonIgnoreProperties({ "foo", "age" })//age将不被序列化到文件,age属性被忽略
class MyValue {
	private String name;
	// will not be written as JSON; nor assigned from JSON:

	private int age;

	/**
	 * @return the name
	 */
	//
	// @JsonIgnore
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("name")
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

class CtorBean {
	public String name;
	public int age;

	// @JsonCreator // constructor can be public, private, whatever
	// private CtorBean(@JsonProperty("name") String name,
	// @JsonProperty("age") int age)
	// {
	// this.name = name;
	// this.age = age;
	// }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
