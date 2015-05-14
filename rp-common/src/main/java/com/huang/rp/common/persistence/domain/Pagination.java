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
//{"page":"1","total":2,"records":"13","rows":[{"id":"13","cell":["13","2007-10-06","Client 3","1000.00","0.00","1000.00",null]},{"id":"12","cell":["12","2007-10-06","Client 2","700.00","140.00","840.00",null]},{"id":"11","cell":["11","2007-10-06","Client 1","600.00","120.00","720.00",null]},{"id":"10","cell":["10","2007-10-06","Client 2","100.00","20.00","120.00",null]},{"id":"9","cell":["9","2007-10-06","Client 1","200.00","40.00","240.00",null]},{"id":"8","cell":["8","2007-10-06","Client 3","200.00","0.00","200.00",null]},{"id":"7","cell":["7","2007-10-05","Client 2","120.00","12.00","134.00",null]},{"id":"6","cell":["6","2007-10-05","Client 1","50.00","10.00","60.00",""]},{"id":"5","cell":["5","2007-10-05","Client 3","100.00","0.00","100.00","no tax at all"]},{"id":"4","cell":["4","2007-10-04","Client 3","150.00","0.00","150.00","no tax"]}],"userdata":{"amount":3220,"tax":342,"total":3564,"name":"Totals:"}}
	private Integer page;//当前页码
	private Integer records;//每页记录数
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
