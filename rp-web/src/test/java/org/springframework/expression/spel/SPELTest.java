/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.springframework.expression.spel;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

//import static org.junit.Assert.*;  

/**
 * 主要测试了下SPEL的一些基本功能
 * <br>
 * <a>
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html
 * </a>
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月10日 上午10:03:48
 * <p>
 * Version: 1.0
 */
public class SPELTest {

	//@Test
	public void test1() {
		SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
			    this.getClass().getClassLoader());
		ExpressionParser parser = new SpelExpressionParser(config);
		Expression exp = parser.parseExpression("'Hello World'.concat('!')");// 这个很类似javax.script包的一些功能
		String message = (String) exp.getValue();
		System.out.println(message);
		boolean b=parser.parseExpression(
		        "'xyz' instanceof T(int)").getValue(Boolean.class);

	}

	//@Test
	public void test2() {
		// Create and set a calendar
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);
		Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");

		EvaluationContext context = new StandardEvaluationContext(tesla);
		//String name = (String) exp.getValue(context);
		String name = (String) exp.getValue(tesla);
		System.out.println(name);
		
		Expression exp1 = parser.parseExpression("name == 'Nikola Tesla'");
		boolean result = exp1.getValue(context, Boolean.class); // evaluates to true
		System.out.println(result);
	}
	
	//@Test
	public void test3(){
		class Simple {
		    public List<Boolean> booleanList = new ArrayList<Boolean>();
		}

		Simple simple = new Simple();

		simple.booleanList.add(true);

		StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
		ExpressionParser parser = new SpelExpressionParser();
		
		// false is passed in here as a string. SpEL and the conversion service will
		// correctly recognize that it needs to be a Boolean and convert it
		parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");

		// b will be false
		Boolean b = simple.booleanList.get(0);
	}
	

}














class Inventor{
	private String name;
	private Date birthday;
	private String nationality;
	
	public Inventor(String name,Date birthday,String nationality){
		this.name=name;
		this.birthday=birthday;
		this.nationality=nationality;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}
