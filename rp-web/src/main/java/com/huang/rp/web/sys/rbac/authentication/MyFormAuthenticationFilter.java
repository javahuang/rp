package com.huang.rp.web.sys.rbac.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @类名: MyFormAuthenticationFilter
 * @作者: rp
 * @生成时间: 2014年11月1日 下午2:59:25
 * @描述:
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	Logger log = LoggerFactory.getLogger(MyFormAuthenticationFilter.class);

	public static final String LOGIN_TYPE = "loginType";
	public static final String KEY = "key";
	public static final String URL = "url";

	private String key = KEY;
	private String loginType = LOGIN_TYPE;
	private String url = URL;

	public String getKey() {
		return key;
	}

	public String getLoginType() {
		return loginType;
	}

	public String getUrl() {
		return url;
	}

	/*
	 * public String getTenantName() { return tenantName; }
	 */

	protected String getKey(ServletRequest request) {
		return WebUtils.getCleanParam(request, getKey());
	}

	protected String getLoginType(ServletRequest request) {
		return WebUtils.getCleanParam(request, getLoginType());
	}

	protected String getUrl(ServletRequest request) {
		return WebUtils.getCleanParam(request, getUrl());
	}

	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		String username = getUsername(request);
		//注册完毕,可以直接执行登录操作 需要将parameter参数username(注册名)转化为email/phone
		if(StringUtils.isNotBlank(WebUtils.getCleanParam(request, "email"))){
			username=WebUtils.getCleanParam(request, "email");
		}else if(StringUtils.isNotBlank(WebUtils.getCleanParam(request, "mobilePhoneNumber"))){
			username=WebUtils.getCleanParam(request, "mobilePhoneNumber");
		}
		String password = getPassword(request);
		String key = getKey(request);
		String jumpUrl = getUrl(request);
		boolean rememberMe = isRememberMe(request);
		request.setAttribute("key", key);
		String host = getHost(request);
		return new MyAuthenticationToken(username, password, rememberMe, host, key, jumpUrl);
	}

	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {//post方法将执行此拦截器
				if (log.isTraceEnabled()) {
					log.trace("Login submission detected.  Attempting to execute login.");
				}
				return executeLogin(request, response);
			} else {
				if (log.isTraceEnabled()) {
					log.trace("Login page view.");
				}
				// allow them to see the login page ;)
				return true;
			}
		} else {
			if (log.isTraceEnabled()) {
				log.trace("Attempting to access a path which requires authentication.  Forwarding to the "
						+ "Authentication url [" + getLoginUrl() + "]");
			}
			saveRequestAndRedirectToLogin(request, response);
			return false;
		}
	}
	
	 protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		  	Subject subject = getSubject(request, response);
		  	if(subject.isAuthenticated()||subject.isRemembered()){
		  		try {
					WebUtils.issueRedirect(request, response, "index.html");
					return true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  	}
	        return false;
		 
	    }
	
	/**
	 * 
	 * @生成时间:   2014年11月6日 下午12:45:44
	 * @方法说明:  重写登录方法,无论登录重新或者失败都返回到前台字符串 
	 * @参数:      
	 * @返回值:
	 * @异常:
	 */
	public boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken "
					+ "must be created in order to execute a login attempt.";
			throw new IllegalStateException(msg);
		}
		PrintWriter out = null;
		try {
			
			Subject subject = getSubject(request, response);
			subject.login(token);
			//如果此处是注册操作,关闭流会导致后续异常
			if(StringUtils.isNotBlank(WebUtils.getCleanParam(request, "email"))){
				return true;
			}
			out=response.getWriter();
			out.print("success");
		} catch (UnknownAccountException e) {
			out.print("nameerror");
		} catch (IncorrectCredentialsException e) {
			out.print("passworderror");
		} catch (LockedAccountException e) {
			out.print("userlocked");
		} catch(AuthenticationException e){
			out.print("unknownameerror");
		}
		finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
		//
		return false;
	}

}
