/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.blog.filter;

import com.huang.rp.common.persistence.fliter.QueryFilter;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月21日 上午10:14:26
 * <p>Version: 1.0
 */
public class BlogPostsFilter extends QueryFilter{
	private Long postAuthor;//文章作者
	private String parCode;//参数类型
	
	public Long getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(Long postAuthor) {
		this.postAuthor = postAuthor;
	}

	public String getParCode() {
		return parCode;
	}

	public void setParCode(String parCode) {
		this.parCode = parCode;
	}
	

}
