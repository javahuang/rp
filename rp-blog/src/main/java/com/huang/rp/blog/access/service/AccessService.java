/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huang.rp.blog.access.filter.AccessFilter;
import com.huang.rp.blog.post.dao.BlogPostsMapper;
import com.huang.rp.blog.post.domain.BlogPosts;
import com.huang.rp.blog.post.domain.BlogPostsExample;
import com.huang.rp.blog.post.domain.BlogPostsWithBLOBs;
import com.huang.rp.common.Constants;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月25日 下午7:31:07
 * <p>Version: 1.0
 */
@Service
public class AccessService {

	@Autowired
	BlogPostsMapper postMapper;
	/**
	 * 获取文章
	 * @param post
	 */
	public BlogPostsWithBLOBs getArticle(BlogPostsWithBLOBs post) {
		if(StringUtils.isNotBlank(post.getPostName())){
			BlogPostsExample exp=new BlogPostsExample();
			exp.createCriteria().andPostNameEqualTo(post.getPostName());
			List<BlogPostsWithBLOBs> postList=postMapper.selectByExampleWithBLOBs(exp);
			if(postList.size()==1){
				post=postList.get(0);
				return post;
			}
		}
		long id=0;
		if((id=post.getId())!=0){
			post=postMapper.selectByPrimaryKey(id);
		}
		return post;
	}

	/**
	 * 获取摘要
	 * @param filter
	 * @return
	 */
	public List<BlogPostsWithBLOBs> getArticleExcerptListByFilter(AccessFilter filter) {
		if(filter==null)
			filter=new AccessFilter();
		filter.setRows(Constants.POST_LIST_PAGE_SIZE);
		return postMapper.selectArticleExcerptByFilter(filter);
	}
}
