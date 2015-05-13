/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.sys.rbac.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huang.rp.sys.rbac.dao.SysUserMapper;
import com.huang.rp.sys.rbac.domain.SysUser;

/**
 * 基于角色的访问控制
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月13日 下午4:35:08
 * <p>Version: 1.0
 */
@Service
public class RbacService {
	@Autowired
	SysUserMapper sysUserMapper;
	/**
	 * @param user
	 */
	public void addUser(SysUser user) {
		user.setCreateDate(new Date());
		sysUserMapper.insertSelective(user);
	}

}
