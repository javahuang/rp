/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.persistence.domain;

import java.util.List;

/**
 * jqgrid分页实体类
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月22日 下午6:07:45
 * <p>Version: 1.0
 */
public class Pagination<T> {
	private Integer page=1;//当前页码
	private Integer records=15;//每页记录数
	private Integer total;//总记录数
	private List<T> rows;//数据集
	
	public Pagination(){
	}

	/**
	 * @param page
	 * @param records
	 * @param total
	 * @param rows
	 */
	public Pagination(Integer page, Integer records, Integer total, List<T> rows) {
		super();
		this.page = page;
		this.records = records;
		this.total = total;
		this.rows = rows;
	}


	public Integer getPage() {
		return page;
	}

	public Pagination<T> setPage(Integer page) {
		this.page = page;
		return this;
	}

	public Integer getRecords() {
		return records;
	}

	public Pagination<T> setRecords(Integer records) {
		this.records = records;
		return this;
	}

	public Integer getTotal() {
		return total;
	}

	public Pagination<T> setTotal(Integer total) {
		this.total = total;
		return this;
	}

	public List<T> getRows() {
		return rows;
	}

	public Pagination<T> setRows(List<T> rows) {
		this.rows = rows;
		return this;
	}
	
	
}
