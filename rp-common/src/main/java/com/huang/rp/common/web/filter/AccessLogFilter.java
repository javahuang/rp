/**
 * 
 */
package com.huang.rp.common.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huang.rp.common.utils.LogUtils;

/**
 * 
 * 访问日志
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月23日 下午1:42:59
 * <p>Version: 1.0
 */
public class AccessLogFilter extends BaseFilter{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	public void doFilter(HttpServletRequest httpRequest,HttpServletResponse httpResponse,FilterChain chain) throws IOException, ServletException{
		LogUtils.logAccess(httpRequest);
		chain.doFilter(httpRequest, httpResponse);
	}
}
