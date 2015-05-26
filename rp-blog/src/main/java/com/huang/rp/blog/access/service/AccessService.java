/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.blog.access.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huang.rp.blog.access.domain.CookieVO;
import com.huang.rp.blog.access.filter.AccessFilter;
import com.huang.rp.blog.post.dao.BlogPostsMapper;
import com.huang.rp.blog.post.domain.BlogPostsExample;
import com.huang.rp.blog.post.domain.BlogPostsWithBLOBs;
import com.huang.rp.common.Constants;
import com.huang.rp.common.cache.dao.SysParameterMapper;
import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.cache.domain.SysParameterExample;
import com.huang.rp.common.cache.domain.SysParameterExample.Criteria;
import com.huang.rp.common.exception.ServiceException;
import com.huang.rp.common.utils.Encodes;
import com.huang.rp.common.utils.HttpUtils;
import com.huang.rp.sys.rbac.dao.SysUserMapper;
import com.huang.rp.sys.rbac.domain.SysUser;
import com.huang.rp.sys.rbac.domain.SysUserExample;

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
	@Autowired
	SysParameterMapper sysParameterMapper;
	@Autowired
	SysUserMapper sysUserMapper;
	
	/**
	 * 获取文章
	 * @param post
	 */
	public BlogPostsWithBLOBs getArticle(HttpServletRequest request,BlogPostsWithBLOBs post) {
		CookieVO cookieVO=parseCookie(request);
		if(StringUtils.isNotBlank(post.getPostName())){
			BlogPostsExample exp=new BlogPostsExample();
			exp.createCriteria().andPostNameEqualTo(post.getPostName());
			List<BlogPostsWithBLOBs> postList=postMapper.selectByExampleWithBLOBs(exp);
			if(postList.size()==1){
				post=postList.get(0);
			}else{
				throw new ServiceException("500");
			}
		}
		long id=0;
		if((id=post.getId())!=0){
			post=postMapper.selectByPrimaryKey(id);
		}
		if(post.getPostAuthor()==null)
			throw new ServiceException("500");
		//鼻子文章不做加密
		if(request.getRequestURL().toString().toLowerCase().contains(Constants.WEB_RCL_URL)){
			return post;
		}
		if(StringUtils.isBlank(post.getPostPassword()))
			return post;
		//密码不为空  且cookie post密码和文章post密码不一致 或 userid和文章id不一致将抛出异常
		if(StringUtils.isNotBlank(post.getPostPassword())&&
				(post.getPostPassword().equals(cookieVO.getPostPassword())||//用户输入了解锁文章密码
						(post.getPostAuthor().equals(cookieVO.getUserId())&&StringUtils.isNotBlank(cookieVO.getUserPassword()))))//用户输入了自己的密码
						{//作者一致 但是没有输入密码
			return post;
		}
		throw new ServiceException("500");
	}

	/**
	 * 获取摘要
	 * @param filter
	 * @return
	 */
	public List<BlogPostsWithBLOBs> getArticleExcerptListByFilter(HttpServletRequest request,AccessFilter filter) {
		if(filter==null){
			filter=new AccessFilter();
			filter.setSidx("id");//最近的文章优先显示
			filter.setSord("desc");
		}
		CookieVO cookieVO=parseCookie(request);
		filter.setSearchStr(cookieVO.getSearch());
		filter.setTagId(cookieVO.getTag());
		filter.setUserId(cookieVO.getUserId());
		List<String> searchs=doSearchBefore(filter);
		if(request.getRequestURL().toString().toLowerCase().contains(Constants.WEB_RCL_URL)){
			filter.setUserId(Constants.WEB_RCL_USER_ID);
		}
		if(filter.getRows()==null)
			filter.setRows(Constants.POST_LIST_PAGE_SIZE);
		List<BlogPostsWithBLOBs> excerptList=postMapper.selectArticleExcerptByFilter(filter);
		if(StringUtils.isNotBlank(filter.getSearchStr())&&filter.isHighLight()){
			///高亮显示搜索后的结果
			doSearchAfter(excerptList,searchs);
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
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 * 高亮显示搜索结果
	 * 先将符合条件的所有索引找出来排序
	 * 然后计算相邻两个索引的间隔X是否满足值N
	 * 如果满足则返回当前索引左右相邻的一段字符串
	 * 不满足将X+N算为下一索引左边字符串长度
	 * //<span style="background-color: rgb(255, 255, 0);">测试</span>
	 * @param excerptList
	 */
	public void doSearchAfter(List<BlogPostsWithBLOBs> excerptList,List<String>searchs){
		if(excerptList.size()==0)
			return;
		for(BlogPostsWithBLOBs post:excerptList){
			String postFilter=post.getPostContentFiltered().replace(" ", "");//得到文章的纯文本
			StringBuilder postExcerpt=new StringBuilder();
			//每个搜索关键词显示前后十个字
			List<Integer>indexs=Lists.newArrayList();//找到所有的文字匹配的索引
			for(String s:searchs){
				int n=StringUtils.countMatches(postFilter, s);//得到字段匹配次数 目前
				if(n>0){//我只匹配五次
					int currIndex=0;
					for(int i=0;i<n;i++){
						if(i>5)
							break;
						currIndex=postFilter.indexOf(s,currIndex);
						indexs.add(currIndex);
						currIndex++;
					}
				}
			}
			Collections.sort(indexs);//比较相邻值,如果小于20,则合并
			int tempSub=0;//中间隔了几个值
			int size=indexs.size();
			for(int m=0;m<size;m++){
				int currentIndex=indexs.get(m);
				if(size-1==m){//如果匹配一个,直接返回临近14个字符的字符串
					postExcerpt.append(getSubStrByMidIndex(postFilter,currentIndex,tempSub));
					break;
				}
				int nextIndex=indexs.get(m+1);
				if(nextIndex-currentIndex>14&&tempSub==0){//如果两个索引之间隔了14个字符,则返回当前
					postExcerpt.append(getSubStrByMidIndex(postFilter,currentIndex,0)+"&nbsp;");
				}else if(nextIndex-currentIndex>14&&tempSub!=0){
					postExcerpt.append(getSubStrByMidIndex(postFilter,currentIndex,10+tempSub)+"&nbsp;");
				}else{
					tempSub=tempSub+nextIndex-currentIndex;
				}
			}
			String result=postExcerpt.toString();
			for(String s:searchs){
				result=result.replace(s, "<span style=\"background-color: rgb(255, 255, 0);\">"+s+"</span>");
			}
			post.setPostExcerpt(result);
		}
	}
	
	/**
	 * 获取关键词左右的一段字符串
	 * @param srcStr
	 * @param index
	 * @param sub
	 * @return
	 */
	public static String getSubStrByMidIndex(String srcStr,int index,int sub){
		if(sub==0){
			sub=10;//取srcStr从index处左右分别取七个字符串
		}
		int begin=index-sub;//起始值可能随着前面字符串变化
		int end=index+7;//end值一直是+7
		if(begin<0){
			begin=0;
		}
		if(end>=srcStr.length()){
			end=srcStr.length();
		}
		return StringUtils.substring(srcStr,begin, end);
	}
	
	
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
//		String action=request.getParameter("action");
//		String signature=request.getParameter("signature");
//		String short_name="";
		Map<String,String>params=Maps.newHashMap();
		params.put("secret", secret);
		params.put("short_name", "hrps");
		if(!duoshuoSync)
			return;
		String response=HttpUtils.URLGet(duoshuourl, params, "utf-8");
		System.out.println(response);
	}

	/**
	 * 获取时间线列表
	 * @return
	 */
	public Map<String,Map<String,List<BlogPostsWithBLOBs>>> getTimelineList(HttpServletRequest request,AccessFilter filter) {
		if(filter==null)
			filter=new AccessFilter();
		filter.setRows(Integer.MAX_VALUE-1);
		filter.setSord("desc");
		filter.setSidx("id");
		CookieVO cookieVO=parseCookie(request);
		filter.setSearchStr(cookieVO.getSearch());
		filter.setTagId(cookieVO.getTag());
		filter.setUserId(cookieVO.getUserId());
		filter.setHighLight(true);
		List<BlogPostsWithBLOBs> excerptList=getArticleExcerptListByFilter(request,filter);
		Map<String,Map<String,List<BlogPostsWithBLOBs>>> timeline=Maps.newLinkedHashMap();
		for(BlogPostsWithBLOBs spost:excerptList){
			Date postDate=spost.getPostDate();
			DateTime dt=new DateTime(postDate.getTime());
			String yearMonthKey=dt.monthOfYear().getAsText(Locale.ENGLISH)+","+dt.getYearOfEra();////时间轴的key May,2015的形式
			Map<String,List<BlogPostsWithBLOBs>> yearMonthPostMap=timeline.get(yearMonthKey);
			if(yearMonthPostMap==null){
				yearMonthPostMap=Maps.newLinkedHashMap();
				timeline.put(yearMonthKey, yearMonthPostMap);
			}
			String dayKey="Day"+dt.getDayOfMonth();
			List<BlogPostsWithBLOBs>dayPostList=yearMonthPostMap.get(dayKey);
			if(dayPostList==null){
				dayPostList=Lists.newArrayList();
				yearMonthPostMap.put(dayKey, dayPostList);
			}
			dayPostList.add(spost);
			
		}
		return timeline;
	}
	//@Test
	public void test(){
		String s="abcadefaghj";
		int n=StringUtils.countMatches(s, "a");//得到字段匹配次数 目前
		System.out.println(n);
		if(n>0){//我只匹配五次
			int currIndex=0;
			for(int i=0;i<n;i++){
				currIndex=s.indexOf("a",currIndex++);//如果直接在这个地方++是不行的 有点奇怪~
				currIndex++;
				System.out.println(currIndex);
			}
		}
		int index=6;
		int sub=3;
		if(index-sub>0)
		System.out.println(StringUtils.substring(s, index-sub, index+sub));
	}

	/**
	 * 当用户搜索输入 $user username时 后来获取的云为用户设置的云
	 * @param request
	 * @return
	 */
	public List<SysParameter> getTagCloud(HttpServletRequest request) {
		SysParameterExample sysParameter=new SysParameterExample();
		Criteria sysParaCa=sysParameter.createCriteria();
		//读取user cookie 获取当前正在使用的用户 目前设置para_group和用户id对应,目的是将标签和用户关联
		CookieVO cookieVO=parseCookie(request);
		if(cookieVO.getUserId()!=null){
			sysParaCa.andParaGroupEqualTo(cookieVO.getUserId().intValue());
		}
		//从rencl.me域名跳转的只显示他自己的标签
		if(request.getRequestURL().toString().toLowerCase().contains(Constants.WEB_RCL_URL)){
			sysParaCa.andParaGroupEqualTo(Constants.WEB_RCL_USER_ID.intValue());
		}
		List<SysParameter> tagList=sysParameterMapper.selectByExample(sysParameter);
		return tagList;
	}
	
//	/**
//	 * $user username 可以查看该用户下未加密文章
//	 * $user username -p password 可以查看该用户下所有文章
//	 * $password 查看该密码对应的文章
//	 * 从cookie获取用户信息
//	 * @param request
//	 * @return
//	 */
//	public SysUser getUserInfoByCookie(HttpServletRequest request){
//		String userCookie=getCookieValue(request,Constants.COOKIE_NAME_USER);//user cookie
//		if(StringUtils.isNotBlank(userCookie)){
//			if(userCookie.startsWith("$user")){
//				String password="";
//				//判断用户输入是否包含 -p选项
//				if(StringUtils.containsIgnoreCase(userCookie, "-p")){
//					password=StringUtils.substringAfterLast(userCookie, "-p");
//				}
//				userCookie=userCookie.replace("$user", "").trim();
//				if(StringUtils.isNotBlank(userCookie)){
//					SysUserExample userExample=new SysUserExample();
//					userExample.createCriteria().andUsernameEqualTo(userCookie);
//					List<SysUser> users=sysUserMapper.selectByExample(userExample);
//					if(users.size()==1){
//						//如果用户输入密码跟实际密码不一致,还只显示用户未加密文章
//						SysUser user=users.get(0);
//						if(user.getPassword().equalsIgnoreCase(password)){
//							return user;
//						}else{
//							user.setPassword(null);
//							return user;
//						}
//					}
//				}
//					
//			}
//		}
//		return null;
//	}
//	/**
//	 * 获取cookie信息
//	 * @param request
//	 * @param cookieName
//	 * @return
//	 */
//	private String getCookieValue(HttpServletRequest request,String cookieName){
//		Cookie[]cookies=request.getCookies();
//		if(cookies!=null){
//			for(Cookie cookie:cookies){
//				if(cookieName.equals(cookie.getName())){
//					String value=Encodes.urlDecode(cookie.getValue());//必须是 $user username形式
//					return value;
//				}
//			}
//		}
//		return null;
//	}
	/**
	 * 将cookie解析成CookieVO对象
	 * @param request
	 * @return
	 */
	public CookieVO parseCookie(HttpServletRequest request){
		Cookie[]cookies=request.getCookies();
		CookieVO cookieVO=new CookieVO();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				//标签cookie
				String cName=cookie.getName();
				String cValue=Encodes.urlDecode(cookie.getValue());
				if(cName.equalsIgnoreCase(Constants.COOKIE_NAME_TAG)){
					cookieVO.setTag(cValue);
				}
				if(cName.equalsIgnoreCase(Constants.COOKIE_NAME_USER)){
					String userName=null;
					String userPassword=null;
					if(StringUtils.containsIgnoreCase(cValue, "-p")){
						userPassword=StringUtils.substringAfterLast(cValue.toLowerCase(), "-p").trim();
						userName=StringUtils.substringBefore(cValue.toLowerCase(), "-p").replace("$user", "").trim();
					}else{
						userName=cValue.toLowerCase().replace("$user", "").trim();
					}
					SysUserExample userExample=new SysUserExample();
					userExample.createCriteria().andUsernameEqualTo(userName);
					List<SysUser> users=sysUserMapper.selectByExample(userExample);
					if(users.size()==1){
						//如果用户输入密码跟实际密码不一致,还只显示用户未加密文章
						SysUser user=users.get(0);
						if(user.getPassword().equalsIgnoreCase(userPassword)){
							cookieVO.setUserName(userName);
							cookieVO.setUserPassword(userPassword);
						}else{
							cookieVO.setUserName(userName);
						}
						cookieVO.setUserId(user.getId());//此处设置id是为了在显示文章时和postAuthor比对
					}
				}
				if(cName.equalsIgnoreCase(Constants.COOKIE_NAME_PASSWORD)){
					cookieVO.setPostPassword(cValue.toLowerCase().replace("$password", "").trim());
				}
				if(cName.equalsIgnoreCase(Constants.COOKIE_NAME_SEARCH)){
					cookieVO.setSearch(cValue);
				}
			}
		}
		return cookieVO;
	}
	
	
}
