package com.huang.rp.common.utils;  

import org.apache.shiro.SecurityUtils;

import com.huang.rp.common.shiro.ShiroUser;

/**
 * 
 *  @类名:  Securitys
 *  @作者:  rp
 *  @生成时间:  2014年11月6日 下午12:53:38
 *  @描述:安全相关工具类
 */
public class Securitys extends SecurityUtils{

    /***
     * 获取ShiroUser
     * @return
     */
    public static ShiroUser getUser() {
    	ShiroUser shiroUser=(ShiroUser) getSubject().getPrincipal();
    	if(shiroUser==null){
    		return new ShiroUser();
    	}
        return shiroUser; 
    }

    /***
     * 获取用户ID
     * @return userId
     */
    public static Long getUserId() {
        return getUser().getId();
    }

    /**
     * 获取当前用户IP
     * @return tenantId
     */
    public static String getIp() {
        return getUser().getIP();
    }
    
    /**
     * 是否为超级管理员
     * @return isAdmin
     */
    public static boolean isAdmin(){
    	return getUser().isAdmin();
    }
    
    /**
     * 获取用户名
     * @return
     */
    public static String getUserName(){
    	return getUser().getUserName();
    }
    
}
