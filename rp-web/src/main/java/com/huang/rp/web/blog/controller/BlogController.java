/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.MyActionEnter;
import com.google.common.collect.Maps;
import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.persistence.domain.Pagination;
import com.huang.rp.common.persistence.domain.PaginationContext;
import com.huang.rp.common.persistence.fliter.QueryFilter;
import com.huang.rp.common.web.controller.BaseController;
import com.huang.rp.web.blog.domain.BlogPostsWithBLOBs;
import com.huang.rp.web.blog.domain.TagParameter;
import com.huang.rp.web.blog.filter.BlogPostsFilter;
import com.huang.rp.web.blog.service.BlogService;
import com.huang.rp.web.blog.service.FileService;

/**
 * ueditor整合springMVC部分 https://github.com/fex-team/ueditor/issues/357
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年5月6日 下午8:31:59
 * <p>
 * Version: 1.0
 */
@Controller
@RequestMapping("blog")
public class BlogController extends BaseController {
	
	@Value("${config.ueditor.json.path}")
	private String configJSONPath;
	
	@Autowired
	FileService fleService;
	@Autowired
	BlogService blogService;
	
	/**
	 * 与springMVC集成需要修改ueditor提供de
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="ueditorInit",params={"action=config"})
	@ResponseBody
	public String ueditorInit(HttpServletRequest request,HttpServletResponse response){
			@SuppressWarnings("resource")
			ApplicationContext appContext = new ClassPathXmlApplicationContext();
			String baseState;
			InputStream iss=this.getClass().getClassLoader().getResourceAsStream("ueditor/config.json");
			try {
				baseState = new MyActionEnter(request, appContext.getResource(configJSONPath).getInputStream()).exec();
				return baseState;
			} catch (JSONException|IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	/**
	 * 图片上传
	 * 这个地方出了一个bug,当请求头 Accept:* / *; 的时候,会报406错误,修改js,添加Accept:application/json;
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="ueditorInit",params={"action=uploadimage"},produces="application/json")
	@ResponseBody
	public ResponseEntity<?> ueditorUploadImage(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> state=Maps.newHashMap();
		try{
			List<Map<String,String>> fileInfos=fleService.uploadImage(request);
			state.putAll(fileInfos.get(0));
			state.put("state", "SUCCESS");
		}catch(Exception e){
			state.put("state", "上传失败");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,String>>(state, HttpStatus.OK);
	}
	
	/**
	 * 添加文章
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="edit")
	@ResponseBody
	public ResponseEntity<?> editBlogPost(BlogPostsWithBLOBs blogPost,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> state=Maps.newHashMap();
		String[]tags=request.getParameterValues("tags");
		try{
			blogService.addBlogPost(blogPost,tags);
			state.put("state", "SUCCESS");
		}catch(Exception e){
			state.put("state", "上传失败");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,String>>(state, HttpStatus.OK);
	}
	
	/**
	 * 跳转到模块列表
	 * @param filter
	 * @return
	 */
	@RequestMapping("list_{moduleName}")
	public String listBlogPost(@PathVariable String moduleName,BlogPostsFilter filter) {
		return "blog/list_"+moduleName;
	}
	
	@RequestMapping("postGridInit")
	@ResponseBody
	public Pagination<BlogPostsWithBLOBs> gridinit(BlogPostsFilter filter) {
		List<BlogPostsWithBLOBs> cacheList = blogService.listBlogPost(filter);
		Pagination<BlogPostsWithBLOBs> response = PaginationContext.getPagination();
		response.setRows(cacheList);
		return response;
	}
	/**
	 * 两种不同的跳转到blog/init.jsp也蛮方式
	 * 这个是编辑,另外一个是初始化
	 */
	@RequestMapping(value="blogEdit")
	public String blogEdit(Long id,Model model) {
		BlogPostsWithBLOBs blogPost=blogService.selectBlogPost(id);
		model.addAttribute("post", blogPost);
		return "blog/init";
	}
	
	@RequestMapping(value="getBlogContent")
	@ResponseBody
	public BlogPostsWithBLOBs getBlogContent(Long id) {
		BlogPostsWithBLOBs blogPost=blogService.selectBlogPost(id);
		return blogPost;
	}
	
	@RequestMapping(value="tagForm")
	public String tagForm(){
		return "blog/form_tag";
	}
	
	@RequestMapping("tagGridInit")
	@ResponseBody
	public Pagination<TagParameter> tagGridinit(QueryFilter filter) {
		List<TagParameter> cacheList = blogService.listBlogTag(filter);
		Pagination<TagParameter> response = PaginationContext.getPagination();
		response.setRows(cacheList);
		return response;
	}
	
	@RequestMapping(value="addTag")
	@ResponseBody
	public String addTag(SysParameter para){
		try{
			blogService.addTag(para);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败";
		}
	}
}
