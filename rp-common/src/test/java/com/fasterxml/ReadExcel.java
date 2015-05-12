package com.fasterxml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.util.DateUtil;

import com.google.common.collect.Table.Cell;
/**
 * 
 * @author rp
 *
 */

public class ReadExcel {
	 public static void main(String[] args)throws Exception {
	  String path1 = "";//王嘉怡的

	 }
	 /**
	  * 创建CSV file
	  * @param exportData 导出列表
	  * @param head 消息头  name/value对应
	  * @param outPutPath
	  * @param filename
	  * @return
	  */
	 public static File createCSVFile(List<LinkedHashMap<String,String>> exportData,LinkedHashMap<String,String> head,
	            String outPutPath, String filename){
		 File csvFile = null;
	        BufferedWriter csvFileOutputStream = null;
	        try {
	            csvFile = new File(outPutPath +File.separator+filename + ".csv");
	            // csvFile.getParentFile().mkdir();
	            File parent = csvFile.getParentFile();
	            if (parent != null && !parent.exists()) {
	                parent.mkdirs();
	            }
	            csvFile.createNewFile();

	            // GB2312使正确读取分隔符","
	            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
	                    new FileOutputStream(csvFile), "GB2312"), 1024);
	            // 写入文件头部
	            for (Iterator<Entry<String,String>> propertyIterator = head.entrySet().iterator(); propertyIterator
	                    .hasNext();) {
	                java.util.Map.Entry<String,String> propertyEntry = (java.util.Map.Entry<String,String>) propertyIterator
	                        .next();
	                csvFileOutputStream.write("\""
	                        + propertyEntry.getValue().toString() + "\"");
	                if (propertyIterator.hasNext()) {
	                    csvFileOutputStream.write(",");
	                }
	            }
	            csvFileOutputStream.newLine();
	            // 写入文件内容
	            for (Iterator<LinkedHashMap<String,String>> iterator = exportData.iterator(); iterator.hasNext();) { 
	            	LinkedHashMap<String,String> row = (LinkedHashMap<String,String>) iterator.next();  
	                for (Iterator<Entry<String,String>> propertyIterator = head.entrySet().iterator(); propertyIterator
		                    .hasNext();) {
		                java.util.Map.Entry<String,String> propertyEntry = (java.util.Map.Entry<String,String>) propertyIterator
		                        .next();
		                //遍历消息头
		                String key=propertyEntry.getKey();
		                String value=row.get(key);
		                if(value==null){
		                	value="";
		                }
		                csvFileOutputStream.write("\""  +value+ "\"");  
		                if (propertyIterator.hasNext()) {  
		                       csvFileOutputStream.write(",");  
		                    }  
	                }
	                csvFileOutputStream.newLine();
	           }  
	            csvFileOutputStream.flush();  
	            return csvFile;
	        } catch (Exception e) {  
	           e.printStackTrace();  
	           return csvFile;
	        } finally {  
	           try {  
	                csvFileOutputStream.close();  
	            } catch (IOException e) {  
	               e.printStackTrace();
	           }  
	       }  
	 }
	 
	 
	}