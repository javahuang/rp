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
import com.huang.rp.common.cache.CacheUtils;
import com.huang.rp.common.cache.dao.SysParameterMapper;
import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.persistence.fliter.QueryFilter;
import com.huang.rp.common.utils.Securitys;
import com.huang.rp.common.utils.SpringContextHolder;
import com.huang.rp.web.blog.dao.BlogPostTermsMapper;
import com.huang.rp.web.blog.dao.BlogPostsMapper;
import com.huang.rp.web.blog.domain.BlogPostTerms;
import com.huang.rp.web.blog.domain.BlogPostTermsExample;
import com.huang.rp.web.blog.domain.BlogPostsWithBLOBs;
import com.huang.rp.web.blog.domain.TagParameter;
import com.huang.rp.web.blog.filter.BlogPostsFilter;

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
	@Autowired
	SysParameterMapper sysParameterMapper;
	
	@Value("${file.server.path}")
	String fileServerPath;
	private BlogPostsFilter filter;
	/**
	 * 添加文章
	 * @param blogPost 文章实体
	 * @param tags 文章关联标签
	 */
	public void addBlogPost(BlogPostsWithBLOBs blogPost, String[] tags) {
		blogPost.setPostExcerpt(getPostExcerpt(blogPost));
		blogPost.setHasCode(hasCode(blogPost));
		blogPost.setHasPic(false);
		
		if(blogPost.getId()==null){
			blogPost.setPostAuthor(Securitys.getUserId());
			blogPost.setPostDate(new Date());
			blogPost.setPostDateGmt(new Date());
			blogPostsMapper.insertSelective(blogPost);
		}else{
			blogPost.setPostModified(new Date());
			blogPost.setPostModifiedGmt(new Date());
			blogPostsMapper.updateByPrimaryKeySelective(blogPost);
			BlogPostTermsExample termsExample=new BlogPostTermsExample();
			termsExample.createCriteria().andPostIdEqualTo(blogPost.getId());
			blogPostTermsMapper.deleteByExample(termsExample);
		}
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


	/**
	 * @param filter
	 * @return
	 */
	public List<BlogPostsWithBLOBs> listBlogPost(BlogPostsFilter filter) {
		List<BlogPostsWithBLOBs> postList=blogPostsMapper.selectByFilterWithBLOBs(filter);
		return postList;
	}


	/**
	 * 
	 * @param id
	 */
	public BlogPostsWithBLOBs selectBlogPost(Long id) {
		return blogPostsMapper.selectByPrimaryKey(id);
	}
//	@Test
//	public void test(){
//		String s="<pre class=\"brush:js;toolbar:false\">function(){\n\n}</pre><p><br/></p>";
//		String b=s.replace("\n", "$");
//		System.out.println(b);
//	}

	/**
	 * 添加标签
	 * @param para
	 */
	public void addTag(SysParameter para) {
		para.setParaGroup(Securitys.getUserId().intValue());//标签分组
		para.setParaCode(Constants.SYS_PARAMETER_TAGS);//参数类型
		Integer maxCode=sysParameterMapper.getMaxCodeByParaCode(Constants.SYS_PARAMETER_TAGS);
		para.setCode(String.valueOf(maxCode));
		sysParameterMapper.insertSelective(para);
		CacheUtils cacheUtils=SpringContextHolder.getBean(CacheUtils.class);
		cacheUtils.refreshCache(Constants.CACHE_SYS_PARAMETER);
		//CacheUtils.setCallValue(Constants.CACHE_SYS_PARAMETER, maxCode, para.getValue());//添加到缓存里面
	}

	/**
	 * 获取
	 * @param filter2
	 * @return
	 */
	public List<TagParameter> listBlogTag(QueryFilter filter2) {
		return sysParameterMapper.selectByFilter(filter2);
	}
}
