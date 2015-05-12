/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.huang.rp.common.persistence.fliter;

import com.huang.rp.common.persistence.domain.PaginationContext;

/**
 * 
 * <p/>
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年4月22日 下午6:15:45
 * <p>
 * Version: 1.0
 */
public class QueryFilter {

	private Integer page = 1;// 当前页码
	private Integer rows = 15;// 每页记录数
	private Integer records;// 总记录数
	private Integer totalPage;// 页码总数
	
	private String sidx;//排序字段
	private String sord;//排序方式 asc/desc

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public static void setLocal(QueryFilter filter) {
		PaginationContext.pag.set(PaginationContext.getPagination()
				.setPage(filter.getPage()).setRecords(filter.getRecords())
				.setTotalPage(filter.getTotalPage()).setRows(filter.getRows()));
	}

}
