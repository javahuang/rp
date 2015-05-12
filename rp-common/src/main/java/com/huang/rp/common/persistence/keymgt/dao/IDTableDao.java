package com.huang.rp.common.persistence.keymgt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.common.persistence.keymgt.domain.IDTableVo;


public interface IDTableDao {

	IDTableVo getIDTables(@Param("prefix") String prefix);
	
	void updateIDTableValue(IDTableVo iDTable);
	
	List<IDTableVo> getAllIDTable();
}
