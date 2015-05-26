/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.domain;

/**
 * cookie对应的值对象
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月25日 下午7:59:58
 * <p>Version: 1.0
 */
public class CookieVO {
	private String userName;//对应"user" cookie  <$user username -p password>
	private String userPassword;//同上
	private String postPassword;//对应"pwd" cookie	<$password pwd>
	private String tag;//对应"tag" cookie 在博客列表页面点击标签产生
	private String search;//对应"search" cookie 对应普通的搜索
	private Long userId;//
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPostPassword() {
		return postPassword;
	}
	public void setPostPassword(String postPassword) {
		this.postPassword = postPassword;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	

}
