/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.persistence.domain;

import java.util.List;

/**
 * 分页实体类
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月22日 下午6:07:45
 * <p>Version: 1.0
 */
public class Pagination<T> {

	private Integer page=1;//当前页码
	private Integer rows=15;//每页记录数
	private Integer records;//总记录数
	private Integer totalPage;//页码总数
	private List<T> dataList;//数据集
	
	public Pagination(){
	}
	
	/**
	 * @param page
	 * @param rows
	 * @param records
	 * @param totalPage
	 * @param dataList
	 */
	public Pagination(Integer page, Integer rows, Integer records,
			Integer totalPage, List<T> dataList) {
		super();
		this.page = page;
		this.rows = rows;
		this.records = records;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

	public Integer getPage() {
		return page;
	}
	public Pagination<T> setPage(Integer page) {
		this.page = page;
		return this;
	}
	public Integer getRows() {
		return rows;
	}
	public Pagination<T> setRows(Integer rows) {
		this.rows = rows;
		return this;
	}
	public Integer getRecords() {
		return records;
	}
	public Pagination<T> setRecords(Integer records) {
		this.records = records;
		return this;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public Pagination<T> setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
		return this;
	}
	public List<T> getDataList() {
		return dataList;
	}
	
	public Pagination<T> setDataList(List<T> dataList) {
		this.dataList = dataList;
		return this;
	}
}
