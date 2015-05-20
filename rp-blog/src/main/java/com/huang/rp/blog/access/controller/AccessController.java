/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
import com.huang.rp.common.Constants;
import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.utils.Encodes;
import com.huang.rp.common.utils.HttpUtils;
import com.huang.rp.sys.rbac.domain.SysUser;

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
	 * 通过cookie的形式传值
	 * 点击"大黄"会清除保存的cookie
	 * cookie作用:1.点击标签刷新页面后,能保存之前的标签
	 * 2.刷新页面之后,搜索的内容依然存在
	 * 文章的摘要
	 * @return
	 */
	@RequestMapping(value="postList")
	public String articleExcerptListAccess(HttpServletRequest request,AccessFilter filter,Model model){
		Cookie[]cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(Constants.COOKIE_NAME_SEARCH.equals(cookie.getName()))
					filter.setSearchStr(Encodes.urlDecode(cookie.getValue()));
				if(Constants.COOKIE_NAME_TAG.equals(cookie.getName()))
					filter.setTagId(Encodes.urlDecode(cookie.getValue()));
			}
		}
		filter.setSidx("id");//最近的文章优先显示
		filter.setSord("desc");
		List<BlogPostsWithBLOBs> postList=accessService.getArticleExcerptListByFilter(filter);
		model.addAttribute("postList", postList);
		return "index/postlist";
	}
	
	/**
	 * 实时同步多说的评论
	 * @param request
	 * @param filter
	 * @param model
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
	public ModelAndView timeline(){
		ModelAndView mav=new ModelAndView();
		Map<String,Map<String,List<BlogPostsWithBLOBs>>> timeline=accessService.getTimelineList(null);
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
		Cookie[]cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(Constants.COOKIE_NAME_SEARCH.equals(cookie.getName())){
					filter.setHighLight(true);
					filter.setSearchStr(Encodes.urlDecode(cookie.getValue()));
				}
				if(Constants.COOKIE_NAME_TAG.equals(cookie.getName()))
					filter.setTagId(Encodes.urlDecode(cookie.getValue()));
			}
		}
		//判断cookie是否有用户信息
		SysUser user=accessService.getUserInfoByCookie(request);
		if(user!=null)
			filter.setUsers(String.valueOf(user.getId()));
		Map<String,Map<String,List<BlogPostsWithBLOBs>>> timeline=accessService.getTimelineList(filter);
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
