/**
 * 
 */
package com.huang.rp.web.sys.rbac.authentication;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;

/**
 *  @类名:  MyUserFliter
 *  @作者:  rp
 *  @生成时间:  2014年11月3日 下午7:15:18
 *  @描述:  having a known principal.  This means that any user who is authenticated or remembered via a
 *  'remember me' feature will be allowed access from this filter.
 *  
 *  留作以后使用的时候再做拓展
 */
public class MyUserFliter extends UserFilter{
	
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = getSubject(request, response);
            // If principal is not null, then the user is known and should be allowed access.
            boolean isRemember=subject.isRemembered();
            return subject.getPrincipal() != null;
        }
    }

    
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        saveRequestAndRedirectToLogin(request, response);
        return false;
    }

}
