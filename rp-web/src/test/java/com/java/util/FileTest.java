/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.java.util;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.google.common.io.Files;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月7日 下午11:01:45
 * <p>Version: 1.0
 */
public class FileTest {
	
	@Test
	public void test1(){
			File f=new File("D://t1//t2/txt");
			try {
				Files.createParentDirs(f);
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
