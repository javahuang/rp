/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huang.rp.blog.access.filter.AccessFilter;
import com.huang.rp.blog.access.service.AccessService;
import com.huang.rp.blog.post.domain.BlogPostsWithBLOBs;
import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.exception.BaseException;
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
	
	Logger log=LoggerFactory.getLogger(getClass());
	
	@Autowired
	AccessService accessService;
	/**
	 * 入口页面
	 * @param request
	 * @param filter
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request,AccessFilter filter,Model model){
		List<BlogPostsWithBLOBs> articleList=accessService.getArticleList(request,filter);
		model.addAttribute("articleList", articleList);
		model.addAttribute("filter", filter);
		return "homepage";
	}
	/**
	 * method=RequestMethod.GET
	 * 控制器的入口,采用两种方式
	 * 1.文章ID 
	 */
	//@RequiresPermissions("")
	@RequestMapping(value="article/{articleId:[\\d]+}")
	public String articleIdAccess(@PathVariable("articleId")long id,HttpServletRequest request,Model model){
		try{
			BlogPostsWithBLOBs post=new BlogPostsWithBLOBs();
			post.setId(id);
			post=accessService.getArticle(request,post);
			model.addAttribute("article", post);
			List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(request,null);
			model.addAttribute("postList", postList);
			if(HttpUtils.isAjaxRequest(request))
				return "index/article";
			return "index";
		}catch(Exception e){
			log.error(e.getMessage());
			throw new BaseException(e.getMessage());
		}
	}
	@Value("${connection.url}")
	String url;
	
	/**
	 * 2.文章的postName
	 * @return 文章内容
	 */
	@RequestMapping(value="article/{postName:\\D.+}")
	public String articlePostNameAccess(@PathVariable("postName")String postName,HttpServletRequest request,Model model){
		try{
			BlogPostsWithBLOBs post=new BlogPostsWithBLOBs();
			post.setPostName(postName);
			post=accessService.getArticle(request,post);
			model.addAttribute("article", post);
			List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(request,null);
			model.addAttribute("postList", postList);
			if(HttpUtils.isAjaxRequest(request))
				return "index/article";
			return "index";
		}catch(Exception e){
			log.error(e.getMessage());
			throw new BaseException(e.getMessage());
		}
	}
	/**
	 * 通过cookie的形式传值
	 * 点击"大黄"会清除保存的cookie
	 * cookie作用:1.点击标签刷新页面后,能保存之前的标签
	 * 2.刷新页面之后,搜索的内容依然存在
	 * 文章的摘要
	 * @return
	 */
	@RequestMapping(value="postList")
	public String articleExcerptListAccess(HttpServletRequest request,AccessFilter filter,Model model){
		filter.setSidx("id");//最近的文章优先显示
		filter.setSord("desc");
		List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(request,filter);
		model.addAttribute("postList", postList);
		return "index/postlist";
	}
	
	/**
	 * 实时同步多说的评论
	 * @param request
	 * @return
	 */
	@RequestMapping(value="comment")
	public void duoshuoComment(HttpServletRequest request){
		accessService.doComment(request);
	}
	
	/**
	 * 时间轴
	 * @return
	 */
	@RequestMapping(value="timeline")
	public ModelAndView timeline(HttpServletRequest request,AccessFilter filter){
		
		ModelAndView mav=new ModelAndView();
		Map<String,Map<String,List<BlogPostsWithBLOBs>>> timeline=accessService.getTimelineList(request,filter);
		mav.addObject("timeline", timeline);
		mav.setViewName("timeline");
		return mav;
	}//
	
	/**
	 * 时光机搜索功能
	 * @param filter
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="timelineSearch")
	public String timelineSearch(AccessFilter filter,Model model,HttpServletRequest request){
//		//判断cookie是否有用户信息
//		SysUser user=accessService.getUserInfoByCookie(request);
//		if(user!=null)
//			filter.setUsers(String.valueOf(user.getId()));
		Map<String,Map<String,List<BlogPostsWithBLOBs>>> timeline=accessService.getTimelineList(request,filter);
		model.addAttribute("timeline", timeline);
		return "timeline/posttimeline-wrapper";
	}
	/**
	 * 标签云初始化
	 * @return
	 */
	@RequestMapping(value="getTags")
	@ResponseBody
	public List<SysParameter>tagCloudInit(HttpServletRequest request){
		return accessService.getTagCloud(request);
	}

}
