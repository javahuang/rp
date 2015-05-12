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
 * <p>Date: 2015年4月14日 下午8:55:52
 * <p>Version: 1.0
 */
public class TargetBean {

    private String pk;

    private String name;

    private String binaryData;

    public void setPk(String pk) {
        this.pk = pk;
    }

    public void setName(String name) {
        this.name = name;
    }

	/**
	 * @return the binaryData
	 */
	public String getBinaryData() {
		return binaryData;
	}

	/**
	 * @param binaryData the binaryData to set
	 */
	public void setBinaryData(String binaryData) {
		this.binaryData = binaryData;
	}

	/**
	 * @return the pk
	 */
	public String getPk() {
		return pk;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
    
    
}              
