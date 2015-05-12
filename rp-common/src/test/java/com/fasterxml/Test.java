/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.fasterxml;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月5日 上午9:59:42
 * <p>Version: 1.0
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("F:\\杰之能\\sumsung平板数据");
		File[]files=f.listFiles();
		String reg1=".*_950_.*\\.xml";
		String reg2=".*_951_.*\\.xml";
		String reg7=".*_955_.*\\.xml";
		String reg9=".*_962_.*\\.xml";
		String reg11=".*_964_.*\\.xml";
		String reg13=".*_966_.*\\.xml";
		String reg15=".*_968_.*\\.xml";
		for(File file:files){
			
		}
	}
	
	// 复制文件
		public static void copyFile(File sourceFile, File targetFile)
				throws IOException {
			// 新建文件输入流并对它进行缓冲
			FileInputStream input = new FileInputStream(sourceFile);
			BufferedInputStream inBuff = new BufferedInputStream(input);

			// 新建文件输出流并对它进行缓冲
			FileOutputStream output = new FileOutputStream(targetFile);
			BufferedOutputStream outBuff = new BufferedOutputStream(output);

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();

			// 关闭流
			inBuff.close();
			outBuff.close();
			output.close();
			input.close();
		}
		
		/**
		 * 将字符串集合输出到文件
		 */
		public static void writeToFile(String dirname,List<String> files) throws Exception {
			// 创建输出文件
			File f = new File(dirname);
			 File parent = f.getParentFile();
	         if (parent != null && !parent.exists()) {
	             parent.mkdirs();
	             f.createNewFile();
	        }
			if (!f.exists()) {
				f.createNewFile();
			}
			StringBuffer sb = new StringBuffer();
			for (String s : files) {
				sb.append(s + "\r\n");// 换行
			}
			byte[] buff = new byte[] {};
			try {
				buff = sb.toString().getBytes();
				FileOutputStream out = new FileOutputStream(f);
				out.write(buff, 0, buff.length);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

}
