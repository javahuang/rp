package com.huang.rp.common.persistence.keymgt.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.common.persistence.keymgt.domain.IDTableVo;
import com.huang.rp.common.persistence.keymgt.domain.IDTableVoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface IDTableVoMapper {
    int countByExample(IDTableVoExample example);

    int deleteByExample(IDTableVoExample example);

    int deleteByPrimaryKey(Integer idId);

    int insert(IDTableVo record);

    int insertSelective(IDTableVo record);

    List<IDTableVo> selectByExample(IDTableVoExample example);

    IDTableVo selectByPrimaryKey(Integer idId);

    int updateByExampleSelective(@Param("record") IDTableVo record, @Param("example") IDTableVoExample example);

    int updateByExample(@Param("record") IDTableVo record, @Param("example") IDTableVoExample example);

    int updateByPrimaryKeySelective(IDTableVo record);

    int updateByPrimaryKey(IDTableVo record);
}