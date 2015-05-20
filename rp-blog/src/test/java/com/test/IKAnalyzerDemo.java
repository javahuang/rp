/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.test;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年5月17日 下午7:47:35
 * <p>
 * Version: 1.0
 */
public class IKAnalyzerDemo {
	public static void main(String[] args) throws IOException {
		String text = "test  a reader fff";
		StringReader sr = new StringReader(text);
		IKSegmenter ik = new IKSegmenter(sr, true);
		Lexeme lex = null;
		while ((lex = ik.next()) != null) {
			System.out.print(lex.getLexemeText() + "%");
		}
	}
	
	public void test() throws IOException{
		  String text="基于java语言开发的轻量级的中文分词工具包";  
	        //创建分词对象  
	        Analyzer anal=new IKAnalyzer(true);       
	        StringReader reader=new StringReader(text);  
	        //分词  
	        TokenStream ts=anal.tokenStream("", reader);  
	        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
	        //遍历分词数据  
	        while(ts.incrementToken()){  
	            System.out.print(term.toString()+"|");  
	        }  
	        reader.close();  
	        System.out.println();  
	    }  
}
