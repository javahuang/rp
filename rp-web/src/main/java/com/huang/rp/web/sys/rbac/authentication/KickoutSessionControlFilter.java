/**
 * 
 */
package com.huang.rp.web.sys.rbac.authentication;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.huang.rp.common.utils.Securitys;


/**
 * @类名: KickoutSessionControlFilter
 * @作者: rp
 * @生成时间: 2014年11月1日 上午11:43:00
 * @描述: shiro 过滤器,并发登录人数控制
 */
@SuppressWarnings("unused")
public class KickoutSessionControlFilter extends AccessControlFilter {

	
	private String kickoutUrl; //踢出后到的地址
    private boolean kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private int maxSession = 1; //同一个帐号最大会话数 默认1

    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }
    
	/**
	 * @生成时间: 2014年11月1日 下午12:00:59
	 * @方法说明:是否允许访问
	 * @参数:
	 * @返回值:
	 * @异常:
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @生成时间: 2014年11月1日 下午12:00:59
	 * @方法说明: 当访问拒绝时,是否已经处理了
	 * @参数:
	 * @返回值:true 需要继续进行处理  false 返回
	 * @异常:
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		Subject subject=getSubject(request, response);
		if(!subject.isAuthenticated()&&!subject.isRemembered()){
			//如果没有登录,该过滤器执行完毕
			return true;
		}
		Session session=subject.getSession();
		String loginname=Securitys.getUserName();
		Serializable sessionId = session.getId();
		//TODO 同步控制
        Deque<Serializable> deque = cache.get(loginname);
        if(deque == null) {
            deque = new LinkedList<Serializable>();
            cache.put(loginname, deque);
        }

        //如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if(!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            deque.push(sessionId);
        }

        //如果队列里的sessionId数超出最大会话数，开始踢人
        while(deque.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if(kickoutAfter) { //如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } else { //否则踢出前者
                kickoutSessionId = deque.removeLast();
            }
            try {
                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                if(kickoutSession != null) {
                    //设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                }
            } catch (Exception e) {//ignore exception
            }
        }

        //如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            //会话被踢出了
            try {
                subject.logout();
            } catch (Exception e) { //ignore
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            return false;
        }
        return true;
	}

}
