/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.fasterxml;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月5日 上午10:36:41
 * <p>Version: 1.0
 */

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.junit.Test;

import sun.misc.BASE64Decoder;

public class XmlParser {
	private static Map<String,Integer>pst=null;
	public static void main(String[]args) throws Exception{
//		String regEx="^.+[-_]955[-_].*\\.xml$";
//		String xml="12512293_955-_2.xml";
//		Pattern pat = Pattern.compile(regEx);  
//		Matcher mat = pat.matcher(xml);  
//		boolean rs = mat.find();
//		System.out.println(rs);
		String path="F:\\杰之能\\data-revover\\15年5月12日";
		String descpath="F:\\杰之能\\data-revover\\导出";
		String logname="F:\\杰之能\\data-revover\\导出\\log.txt";
		regist(path,descpath,false,3,logname);
	}
	
	//登记问卷 decode true需要解密 type 1登记 2入选 3登记和入选
	/**
	 * 
	 * @param sourcepath 源文件目录
	 * @param descpath 
	 * @param decode 是否需要解密
	 * @param type 1登记 2入选 3登记和入选
	 * @param logname 
	 */
	public static void regist(String sourcepath,String descpath,boolean decode,int type,String logname){
		File file=new File(sourcepath);
		File[] files=file.listFiles();
		List<String>logs=new ArrayList<String>();
		
		List<LinkedHashMap<String,String>> exportDataRegist=new ArrayList<LinkedHashMap<String,String>>();
		String outPutPathRegist=descpath;
		String filenameRegist="pids";
		/**入选*/
		LinkedHashMap<String,String> headIn=new LinkedHashMap<String,String>();
		headIn.put("pid", "pid");
		headIn.put("state", "问卷知情同意");
		headIn.put("fileName", "fileName");
		headIn.put("paperid", "paperid");
		headIn.put("size", "size");
		for(File f:files){
			LinkedHashMap<String,String> ansMap=new LinkedHashMap<String,String>();
				try{
					ansMap.put("fileName", f.getName());
					ansMap.put("size", f.length()+"");
				    ansMap.put("paperid",getPaperId(f.getName()) );
					InputStream is=new FileInputStream(f);
					InputStream iss=null;
					Document doc=null;
					//创建一个SAXBuilder对象
			        SAXBuilder saxBuilder = new SAXBuilder();     
			        //读取prop.xml资源
					if(decode){
						BASE64Decoder b=new BASE64Decoder();
						byte[] xmls=b.decodeBuffer(is);
						iss=new ByteArrayInputStream(xmls);
						doc = saxBuilder.build(iss);//加密问卷
					}else{
						doc = saxBuilder.build(is);//未加密问卷
					}
			        //获取根元素(prop)
			        Element root = doc.getRootElement();
			        List<Element> response = root.getChildren("hidden");
			        int count1=0;
			        int count2=0;
			        for(Element res:response){
			    		  List<Element> answer = res.getChildren("answer");
			    		  for(Element ans:answer){
			    			  if(("panelId").equals(ans.getChild("name").getText())){
			    				 String p=ans.getChild("value").getText();
			    				 ansMap.put("pid", p);
			    				 count1++;
			    			  }
			    			  if(("state").equals(ans.getChild("name").getText())){
			    				  String n=ans.getChild("value").getText();
			    				  ansMap.put("state", n);
			    				  count2++;
			    			  }
			    	  }
			      }
			        if(count1!=1||count2!=1){
			        	logs.add(f.getName()+" 文件存在"+"pid:"+count1+" name"+count2);
			        }
			      if(decode)
			    	  iss.close();
			      is.close();
				}catch(Exception e){
					System.out.println(f.getName());
					e.printStackTrace();
					System.out.println("解析登记问卷异常:"+f.getName());
					logs.add("解析登记问卷异常:"+f.getName());
				}finally{
					 exportDataRegist.add(ansMap);
				}
		}
		
		try {
			ReadExcel.createCSVFile(exportDataRegist, headIn, outPutPathRegist, filenameRegist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//mdf_11102728_201405041242.xml
	public static  String  getPaperId(String str){
		String[]ss=str.split("_");
		if(ss.length>1){
			return ss[1].length()<6?ss[1]:null;
		}
		return null;
	}
}

