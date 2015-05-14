/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.blog.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huang.rp.common.Constants;
import com.huang.rp.common.utils.Securitys;
import com.huang.rp.web.blog.dao.BlogPostTermsMapper;
import com.huang.rp.web.blog.dao.BlogPostsMapper;
import com.huang.rp.web.blog.domain.BlogPostTerms;
import com.huang.rp.web.blog.domain.BlogPostsWithBLOBs;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月12日 下午9:46:55
 * <p>Version: 1.0
 */
@Service
@Transactional
public class BlogService {
	
	@Autowired
	BlogPostsMapper blogPostsMapper;
	@Autowired
	BlogPostTermsMapper blogPostTermsMapper;
	
	@Value("${file.server.path}")
	String fileServerPath;
	/**
	 * 添加文章
	 * @param blogPost 文章实体
	 * @param tags 文章关联标签
	 */
	public void addBlogPost(BlogPostsWithBLOBs blogPost, String[] tags) {
		blogPost.setPostAuthor(Securitys.getUserId());
		blogPost.setPostDate(new Date());
		blogPost.setPostDateGmt(new Date());
		blogPost.setPostExcerpt(getPostExcerpt(blogPost));
		blogPost.setHasCode(hasCode(blogPost));
		blogPost.setHasPic(false);
		blogPostsMapper.insertSelective(blogPost);
		Long postId=blogPost.getId();//返回自增长的主键
		if(tags!=null)
		for(String tag:tags){
			BlogPostTerms blogPostTerm=new BlogPostTerms();
			blogPostTerm.setPostId(postId);
			blogPostTerm.setTermId(Long.parseLong(tag));
			blogPostTerm.setType(Constants.SYS_PARAMETER_TAGS);
			blogPostTermsMapper.insertSelective(blogPostTerm);
		}
	}
	
	
	/**
	 * 生成文章的摘要
	 * @param blogPost
	 * @return
	 */
	private String getPostExcerpt(BlogPostsWithBLOBs blogPost){
		//去掉所有的<>
		String blogContent=blogPost.getPostContent();
		Validate.notNull(blogContent);
		String blogExcerpt=blogContent.replaceAll("<[^>]+>", "");//正则的反向字符集  匹配不在指定的范围内的任何字符
		//blogExcerpt=blogExcerpt.replaceAll("\\s+", " ").replaceAll("\\s", ",");
//		if(blogExcerpt.startsWith(",")){
//			blogExcerpt=blogExcerpt.replaceFirst(",", "  ");//行首空两格
//		}
		blogExcerpt=blogExcerpt.trim();
		if(blogExcerpt.length()>50){
			return blogExcerpt.substring(0, 50)+"...";
		}
		return blogExcerpt;
	}
	
	/**
	 * 代码包含图片列表
	 * @param blogPost
	 * @return
	 */
	private List<String> hacPic(BlogPostsWithBLOBs blogPost){
		return null;
	}
	private boolean hasCode(BlogPostsWithBLOBs blogPost){
		return blogPost.getPostContent().contains("class=\"brush:");
	}
}
