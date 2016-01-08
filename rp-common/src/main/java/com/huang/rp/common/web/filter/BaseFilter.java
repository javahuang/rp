/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * 基础过滤器,包装req和rep
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月20日 下午9:21:54
 * <p>
 * Version: 1.0
 */
public class BaseFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(BaseFilter.class);
	
	private final PathMatcher pathMatcher = new AntPathMatcher();
	private final String[] NULL_STRING_ARRAY = new String[0];
    private final String URL_SPLIT_PATTERN = "[, ;\r\n]";//逗号  空格 分号  换行
    
    /**
     * 白名单
     */
    private String[] whiteListURLs = null;

    /**
     * 黑名单
     */
    private String[] blackListURLs = null;
    
	/**页面配置filter init-param*/
	FilterConfig filterConfig;
	@Override
	public final void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
		this.initConfig();
		this.init();
	}
	
	private void initConfig() {
        String whiteListURLStr = this.filterConfig.getInitParameter("whiteListURL");
        whiteListURLs = strToArray(whiteListURLStr);


        String blackListURLStr = this.filterConfig.getInitParameter("blackListURL");
        blackListURLs = strToArray(blackListURLStr);

    }

	private String[] strToArray(String urlStr) {
        if (urlStr == null) {
            return NULL_STRING_ARRAY;
        }
        String[] urlArray = urlStr.split(URL_SPLIT_PATTERN);

        List<String> urlList = new ArrayList<String>();

        for (String url : urlArray) {
            url = url.trim();
            if (url.length() == 0) {
                continue;
            }

            urlList.add(url);
        }

        return urlList.toArray(NULL_STRING_ARRAY);
    }
	/**
	 * 子类覆盖此初始化方法
	 * @throws ServletException
	 */
	public void init() throws ServletException{
		
	}
	
	/**
	 * 子类实现doFilter(httpRequest,httpResponse,chain);
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public final void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String currUrl = httpRequest.getServletPath();
		String ctx=httpRequest.getContextPath();
		ctx=StringUtils.substringBeforeLast(ctx, "?");
		httpRequest.setAttribute("ctx", ctx);
		logger.info("url filter:currenu url:[{}]",currUrl);
		if (isBlackURL(currUrl)) {
            chain.doFilter(request, response);
            return;
        }

        if (!isWhiteURL(currUrl)) {
            chain.doFilter(request, response);
            return;
        }
		doFilter(httpRequest,httpResponse,chain);
		return;
	}
	/**
	 * 子类覆盖此方法
	 * @param httpRequest
	 * @param httpResponse
	 * @param chain
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public void doFilter(HttpServletRequest httpRequest,HttpServletResponse httpResponse,FilterChain chain) throws IOException, ServletException{
		chain.doFilter(httpRequest, httpResponse);
	}
	
	@Override
	public  void destroy() {
		// TODO Auto-generated method stub
	}

	private boolean isWhiteURL(String currentURL) {
        for (String whiteURL : whiteListURLs) {
            if (pathMatcher.match(whiteURL, currentURL)) {
                logger.debug("url filter : white url list matches : [{}] match [{}] continue", currentURL, whiteURL);
                return true;
            }
        }
        logger.debug("url filter : white url list not matches : [{}] not match [{}]",
                currentURL, Arrays.toString(whiteListURLs));
        return false;
    }

    private boolean isBlackURL(String currentURL) {
        for (String blackURL : blackListURLs) {
            if (pathMatcher.match(blackURL, currentURL)) {
                logger.debug("url filter : black url list matches : [{}] match [{}] break", currentURL, blackURL);
                return true;
            }
        }
        logger.debug("url filter : black url list not matches : [{}] not match [{}]",
                currentURL, Arrays.toString(blackListURLs));
        return false;
    }
    
	public String[] getWhiteListURLs() {
		return whiteListURLs;
	}

	public void setWhiteListURLs(String[] whiteListURLs) {
		this.whiteListURLs = whiteListURLs;
	}

	public String[] getBlackListURLs() {
		return blackListURLs;
	}

	public void setBlackListURLs(String[] blackListURLs) {
		this.blackListURLs = blackListURLs;
	}

}
