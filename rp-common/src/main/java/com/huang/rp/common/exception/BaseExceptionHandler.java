/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.exception;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;


/**
 * 控制器增强
 * http://jinnianshilongnian.iteye.com/blog/1866350
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月23日 下午12:17:52
 * <p>Version: 1.0
 */
@ControllerAdvice
public class BaseExceptionHandler{
	private static Logger logger=LoggerFactory.getLogger(BaseExceptionHandler.class);
	 /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({BaseException.class})
    //@ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object processException(NativeWebRequest request, BaseException e) {
    	String message = e.getMessage();
    	
    	if(e instanceof ServiceException){
    		ServiceException se=(ServiceException)e;
    		String redirect =se.getRedirect();
    		Map<String, Object> params = se.getParams();
    		if(StringUtils.isNotBlank(redirect)){
    			ModelAndView mv = new ModelAndView();
                if (params != null) {
                    for (String key : params.keySet()) {
                        mv.addObject(key, params.get(key));
                    }
                }
                mv.addObject("success", false);
                mv.setViewName(redirect);
                return mv;
    		}
    	}
    	return null;
//        if (StringUtils.isNotBlank(e.getMessage())) {
//            
//        } else {
//            Map<String, Object> res = new HashMap<String, Object>();
//            res.put("success", false);
//            res.put("msg", message);
//            ResponseEntity<Map<String, Object>> entity=new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
//            		entity.getHeaders().getContentType()
//            		return entity;
//        }
    }
	
}
