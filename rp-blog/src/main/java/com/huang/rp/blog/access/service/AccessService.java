/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huang.rp.blog.access.filter.AccessFilter;
import com.huang.rp.blog.post.dao.BlogPostsMapper;
import com.huang.rp.blog.post.domain.BlogPostsExample;
import com.huang.rp.blog.post.domain.BlogPostsWithBLOBs;
import com.huang.rp.common.Constants;
import com.huang.rp.common.utils.HttpUtils;

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
		List<String>searchs=doSearchBefore(filter);
		//高亮显示搜索后的结果
		filter.setRows(Constants.POST_LIST_PAGE_SIZE);
		List<BlogPostsWithBLOBs> excerptList=postMapper.selectArticleExcerptByFilter(filter);
		if(StringUtils.isNotBlank(filter.getSearchStr())){
			//doSearchAfter(excerptList,searchs);
		}
		return excerptList;
	}
	/**
	 * 处理搜索字符串
	 * 将中文分词,我目前想到的搜索机制是将分词后的结果使用%搜索
	 * 后续将继承lucene来进行搜索吧
	 * @param filter
	 * @throws IOException 
	 */
	public List<String> doSearchBefore(AccessFilter filter){
		List<String>searchs=Lists.newArrayList();
		if(StringUtils.isBlank(filter.getSearchStr()))
			return null;
		StringReader sr = new StringReader(filter.getSearchStr());
		IKSegmenter ik = new IKSegmenter(sr, true);
		Lexeme lex = null;
		StringBuilder searchStr=new StringBuilder();
		searchStr.append("%");
		try {
			while ((lex = ik.next()) != null) {
				String lexemeText=lex.getLexemeText();
				searchStr.append(lexemeText+"%");
				searchs.add(lexemeText);
			}
			filter.setSearchStr(searchStr.toString());
			return searchs;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 * 高亮显示搜索结果
	 * //<span style="background-color: rgb(255, 255, 0);">测试</span>
	 * @param excerptList
	 */
	public void doSearchAfter(List<BlogPostsWithBLOBs> excerptList,List<String>searchs){
		if(excerptList.size()==0)
			return;
		for(BlogPostsWithBLOBs post:excerptList){
			String excerpt=post.getPostExcerpt();
			
		}
	}
	//
	//3a616f093c7eb348eaf3f291828aeee7
	@Value("${duoshuo.signature}")
	String secret;
	@Value("${duoshuo.url}")
	String duoshuourl;
	@Value("${duoshuo.synccomment}")
	boolean duoshuoSync;
	
	/**
	 * 对多说的评论进行操作
	 * @param request
	 */
	public void doComment(HttpServletRequest request) {
		String action=request.getParameter("action");
		String signature=request.getParameter("signature");
		String short_name="";
		Map<String,String>params=Maps.newHashMap();
		params.put("secret", secret);
		params.put("short_name", "hrps");
		if(!duoshuoSync)
			return;
		String response=HttpUtils.URLGet(duoshuourl, params, "utf-8");
		System.out.println(response);
	}
	
}
