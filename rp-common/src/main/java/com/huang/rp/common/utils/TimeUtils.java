/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.utils;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月21日 下午4:24:38
 * <p>Version: 1.0
 */
public class TimeUtils {

	   public static final String yyyyMMddFormtter="yyyy-MM-dd";
	   public static final String yyyyMMddFormtterRegex="\\d{4}-\\d{1,2}-\\d{1,2}";
	   public static final String yyyMMddHHmmssFormtter="yyyy-MM-dd HH:mm:ss";
	   public static final String yyyyMMddHHmmssFormtterRegex="\\d{4}-\\d{1,2}-\\d{1,2}.*\\d{1,2}:\\d{1,2}:\\d{1,2}";
	   
	   /**
	    * 由字符串获取相关DateTime
	    * @param dateStr
	    * @return
	    */
	   public static DateTime getDateTime(String dateStr){
	      if(dateStr.matches(yyyyMMddFormtterRegex)){
	         return DateTime.parse(dateStr, DateTimeFormat.forPattern(yyyyMMddFormtter));
	      }else if(dateStr.matches(yyyyMMddHHmmssFormtterRegex)){
	         return DateTime.parse(dateStr, DateTimeFormat.forPattern(yyyMMddHHmmssFormtter));
	      }
	      return null;
	   }
	   
	   /**
	    * 获取日期之间的差值 天数
	    * @param dt1
	    * @param dt2
	    * @return
	    */
	   public static int getDateDiff(DateTime dt1,DateTime dt2){
		   Period p=new Period(dt1,dt2,PeriodType.days());
		   return p.getDays();
	   }
	   /**
	    * 获取年月日字符串
	    * @return
	    */
	   public static String getYYMMDDStr(){
		   DateTime dt=new DateTime();
		   StringBuilder sb=new StringBuilder();
		   sb.append(dt.getYear()).append(dt.getMonthOfYear()).append(dt.getDayOfMonth());
		   return sb.toString();
	   }
	   //@Test
	   public void test(){
		   DateTime dt=new DateTime();
		   System.out.println(dt.monthOfYear().getAsText(Locale.ENGLISH));
	   }
}
