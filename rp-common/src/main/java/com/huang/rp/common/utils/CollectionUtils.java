/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 集合常用工具类
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月22日 下午9:18:21
 * <p>Version: 1.0
 */
public class CollectionUtils {
	
	public <T> boolean isBlankList(List<T> list){
		if(list!=null&&list.size()>0)
			return true;
		return false;
	}

	public <T> boolean isNotBlankList(List<T> list){
		return !isBlankList(list);
	}
}
