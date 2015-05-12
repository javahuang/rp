/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.rbac.authentication;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.huang.rp.common.shiro.ShiroUser;
import com.huang.rp.common.utils.PatternUtils;
import com.huang.rp.common.utils.Securitys;
import com.huang.rp.sys.rbac.dao.SysRoleMapper;
import com.huang.rp.sys.rbac.dao.SysRolePermissionMapper;
import com.huang.rp.sys.rbac.dao.SysUserMapper;
import com.huang.rp.sys.rbac.dao.SysUserRoleMapper;
import com.huang.rp.sys.rbac.domain.SysUser;
import com.huang.rp.sys.rbac.domain.SysUserExample;
import com.huang.rp.sys.rbac.domain.SysUserRole;
import com.huang.rp.sys.rbac.domain.SysUserRoleExample;

/**
 * 安全认证:执行认证和授权
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月23日 下午2:07:23
 * <p>
 * Version: 1.0
 */
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	SysUserMapper susUserMapper;
	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	/**
	 * 重写了登录逻辑,会返回前台具体的登录失败信息 MyFormAuthenticationFilter/executeLogin
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (
			AuthenticationToken token) throws AuthenticationException {
		MyAuthenticationToken myToken = (MyAuthenticationToken) token;
		String loginName=myToken.getUsername();//获取登录名 使用手机号或者邮箱登录
		SysUserExample userExample=new SysUserExample();
		if(PatternUtils.matches(loginName, PatternUtils.emailRegex))
			userExample.createCriteria().andEmailEqualTo(loginName);
		else if(PatternUtils.matches(loginName, PatternUtils.telephoneRegex))
			userExample.createCriteria().andMobilePhoneNumberEqualTo(loginName);
		else 
			throw new AuthenticationException("unknown login name");
		SysUser user=null;
		try{
			user=susUserMapper.selectByExample(userExample).get(0);
		}catch(Exception e){
			throw new UnknownAccountException();
		}
		String password=user.getPassword();
		if(!String.valueOf(myToken.getPassword()).equals(password)){
			throw new IncorrectCredentialsException();
		}
		boolean isAdmin=user.getAdmin();
		//获取用户角色列表
		SysUserRoleExample userRoleExample=new SysUserRoleExample();
		if(isAdmin)//admin获取所有的角色
			userRoleExample.createCriteria();
		else
			userRoleExample.createCriteria().andUserIdEqualTo(user.getId());
		List<SysUserRole> susUserRoleList=sysUserRoleMapper.selectByExample(userRoleExample);
		List<Long> roleIdList=Lists.newArrayList();
		for(SysUserRole sur:susUserRoleList){
			roleIdList.add(sur.getRoleId());
		}
		ShiroUser shiroUser=new ShiroUser(user.getId(),user.getUsername(),user.getAdmin(),myToken.getHost(),roleIdList);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(shiroUser,myToken.getPassword(),getName());
		return info;
	}
	
	/**
	 * 该方法将在第一次鉴权时执行(获取角色/权限)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Long userId=Securitys.getUserId();
		boolean isAdmin=Securitys.isAdmin();
		List<Map> roleStrList=susUserMapper.selectUserRoleByid(userId);
		List<Map> permissionStrList=susUserMapper.selectUserPermissionByid(userId);
		if(isAdmin){
			
		}else{
			for(Map role:roleStrList){
				info.addRole(String.valueOf(role.get("name")));
			}
			for(Map permission:permissionStrList){
				info.addStringPermission(String.valueOf(permission.get("name")));
			}
		}
		
		return info;
	}

}
