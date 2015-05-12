/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.web.blog.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.huang.rp.common.utils.Encodes;
import com.huang.rp.common.utils.Exceptions;
import com.huang.rp.common.utils.TimeUtils;
import com.huang.rp.web.blog.dao.BlogFilesMapper;
import com.huang.rp.web.blog.domain.BlogFiles;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月7日 下午2:20:00
 * <p>Version: 1.0
 */
@Service
@Transactional
public class FileService {

	@Autowired
	BlogFilesMapper blogFilesMapper;
	
	@Value("${images.dir}")
	String imageDirPath;
	@Value("${file.server.path}")
	private String fileServerPath;//图片服务器地址
	
	/**
	 * 支持多文件上传
	 * 文件名转化为 hex值
	 * 上传图片
	 * @param request
	 */
	public List<Map<String,String>> uploadImage(HttpServletRequest request) {
		List<Map<String,String>>filePaths=Lists.newArrayList();//返回图片的相对于ctx的相对路径
		if(request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
			Iterator<String> fileNames = multipartRequest.getFileNames();
			while(fileNames.hasNext()){
				String fileName=fileNames.next();
				List<MultipartFile> files=multipartRequest.getFiles(fileName);
				for(MultipartFile singleFile:files){
					String oriFilename=singleFile.getOriginalFilename();
					String suffix=StringUtils.substringAfterLast(oriFilename, ".");//文件后缀
					String destFilePrefix=Encodes.encodeHex(StringUtils.substringBeforeLast(oriFilename, ".").getBytes());
					String destFileName=destFilePrefix+"."+suffix;
					String absPath=imageDirPath+"/"+
							TimeUtils.getYYMMDDStr()+"/"+
							destFileName;//目前文件保存  已当前日期+具体文件名的hex值存放
					String relPath=TimeUtils.getYYMMDDStr()+"/"+destFileName;
					File f=new File(absPath);
					try {
						Files.createParentDirs(f);
						singleFile.transferTo(f);
					} catch (IOException e) {
						Exceptions.unchecked(e);
					}
					BlogFiles blogFile=new BlogFiles();
					blogFile.setAbsPath(absPath);
					blogFile.setRelPath(relPath);
					blogFile.setUpdateDate(new Date());
					blogFile.setFileName(oriFilename);
					blogFilesMapper.insertSelective(blogFile);
					//返回图片信息到前台
					Map<String,String>picInfo=Maps.newHashMap();
					picInfo.put("url", fileServerPath+relPath);
					picInfo.put("title", destFileName);
					picInfo.put("original", oriFilename);
					filePaths.add(picInfo);
				}
			}
		}
		return filePaths;
	}

}
