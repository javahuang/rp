/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package me.hrps.rp.preview.chat.controller;

import me.hrps.rp.preview.chat.domain.PreChatUser;
import me.hrps.rp.preview.chat.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年8月18日 下午8:52:10
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("preview/chat")
public class ChatController {
	@Autowired
	ChatService chatService;
	
	@RequestMapping("regist")
	@ResponseBody
	public String registUser(PreChatUser user){
		return chatService.addUser(user);
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String userLogin(PreChatUser user){
		return chatService.userLogin(user);
	}

}
