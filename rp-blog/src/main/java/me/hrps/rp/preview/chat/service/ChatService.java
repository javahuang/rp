/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package me.hrps.rp.preview.chat.service;

import java.util.List;

import me.hrps.rp.preview.chat.dao.PreChatUserMapper;
import me.hrps.rp.preview.chat.domain.PreChatUser;
import me.hrps.rp.preview.chat.domain.PreChatUserExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年8月18日 下午8:53:37
 * <p>Version: 1.0
 */
@Service
@Transactional
public class ChatService {
	@Autowired
	PreChatUserMapper chatUserMapper;
	
	/**
	 * 注册用户
	 * @param user
	 */
	public String addUser(PreChatUser user) {
		try{
			chatUserMapper.insertSelective(user);
			return "success";
		}catch(Exception e){
			return "fail";
		}
		
	}

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public String userLogin(PreChatUser user) {
		PreChatUserExample exp=new PreChatUserExample();
		exp.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword());
		List<PreChatUser> users=chatUserMapper.selectByExample(exp);
		if(users.size()==1)
			return users.get(0).getId()+"";
		else
			return null;
	}

}
