/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.utils;

import org.springframework.context.MessageSource;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月21日 下午12:21:11
 * <p>Version: 1.0
 */
public class MessageUtils {


    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringContextHolder.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, null);
    }



}
