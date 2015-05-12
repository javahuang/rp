/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.slf4j.domains;


/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月14日 下午8:55:09
 * <p>Version: 1.0
 */
public class SourceBean {

    private Long id;

    private String name;

   // @Mapping("binaryData")
    private String data;

    //@Mapping("pk")
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
    
}              