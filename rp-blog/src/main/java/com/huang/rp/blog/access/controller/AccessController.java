/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huang.rp.blog.access.filter.AccessFilter;
import com.huang.rp.blog.access.service.AccessService;
import com.huang.rp.blog.post.domain.BlogPostsWithBLOBs;
import com.huang.rp.common.utils.HttpUtils;

/**
 * 博客入口
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月24日 下午11:35:38
 * <p>Version: 1.0
 */
@Controller
public class AccessController {
	
	@Autowired
	AccessService accessService;
	
	/**
	 * method=RequestMethod.GET
	 * 控制器的入口,采用两种方式
	 * 1.文章ID 
	 */
	//@RequiresPermissions("")
	@RequestMapping(value="article/{articleId:[\\d]+}")
	public String articleIdAccess(@PathVariable("articleId")long id,HttpServletRequest request,Model model){
		BlogPostsWithBLOBs post=new BlogPostsWithBLOBs();
		post.setId(id);
		post=accessService.getArticle(post);
		model.addAttribute("article", post);
		List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(null);
		model.addAttribute("postList", postList);
		if(HttpUtils.isAjaxRequest(request))
			return "index/article";
		return "index";
	}
	@Value("${connection.url}")
	String url;
	
	/**
	 * 2.文章的postName
	 * @return
	 */
	@RequestMapping(value="article/{postName:\\D.+}")
	public String articlePostNameAccess(@PathVariable("postName")String postName,HttpServletRequest request,Model model){
		BlogPostsWithBLOBs post=new BlogPostsWithBLOBs();
		post.setPostName(postName);
		post=accessService.getArticle(post);
		model.addAttribute("article", post);
		List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(null);
		model.addAttribute("postList", postList);
		if(HttpUtils.isAjaxRequest(request))
			return "index/article";
		return "index";
	}
	/**
	 * 文章的摘要
	 * @return
	 */
	@RequestMapping(value="postList")
	public String articleExcerptListAccess(AccessFilter filter,Model model){
		List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(filter);
		model.addAttribute("postList", postList);
		return "index/postlist";
	}
	
}
