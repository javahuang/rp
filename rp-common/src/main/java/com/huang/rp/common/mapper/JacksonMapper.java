/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 对jackson的一些简单封装
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月21日 下午4:38:12
 * <p>Version: 1.0
 */
public class JacksonMapper {
	
	private static Logger logger=LoggerFactory.getLogger(JacksonMapper.class);
	
	private ObjectMapper mapper;
	
	public JacksonMapper(){
		this(Include.ALWAYS);
	}
	public JacksonMapper(Include include){
		mapper=new ObjectMapper();
		mapper.setSerializationInclusion(include);
	}
	
	public static JacksonMapper nonDefaultJacksonMapper(){
		return new JacksonMapper(Include.NON_DEFAULT);
	}
	/**
	 * 将对象转化为jsonstr
	 * @param obj
	 * @return
	 */
	public static String toJSONString(Object obj){
		JacksonMapper jsonMapper=new JacksonMapper();
		try {
			return jsonMapper.mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("jsckson writeValueAsString error:"+obj,e);
			return null;
		}
	}
	
	
}