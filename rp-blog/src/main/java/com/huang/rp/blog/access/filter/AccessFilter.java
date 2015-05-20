/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.filter;

import com.huang.rp.common.persistence.fliter.QueryFilter;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月25日 下午10:30:36
 * <p>Version: 1.0
 */
public class AccessFilter extends QueryFilter{
	private String tagId;//标签ID
	private String searchStr;//搜索关键字
	boolean highLight=false;//搜索文本是否高亮显示
	private String tags;//标签集合 =1,2,3
	private String users;//用户集合 =1,2,3
	
	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public boolean isHighLight() {
		return highLight;
	}

	public void setHighLight(boolean highLight) {
		this.highLight = highLight;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}
	
	
}
