package com.huang.rp.common.cache.dao;

import com.huang.rp.common.cache.domain.SysParatype;
import com.huang.rp.common.cache.domain.SysParatypeExample;
import com.huang.rp.common.persistence.MyBatisRepository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysParatypeMapper {
    int countByExample(SysParatypeExample example);

    int deleteByExample(SysParatypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParatype record);

    int insertSelective(SysParatype record);

    List<SysParatype> selectByExample(SysParatypeExample example);

    SysParatype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParatype record, @Param("example") SysParatypeExample example);

    int updateByExample(@Param("record") SysParatype record, @Param("example") SysParatypeExample example);

    int updateByPrimaryKeySelective(SysParatype record);

    int updateByPrimaryKey(SysParatype record);
}