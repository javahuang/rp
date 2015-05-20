package com.huang.rp.common.cache.dao;

import com.huang.rp.common.cache.domain.SysParameter;
import com.huang.rp.common.cache.domain.SysParameterExample;
import com.huang.rp.common.persistence.MyBatisRepository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysParameterMapper {
    int countByExample(SysParameterExample example);

    int deleteByExample(SysParameterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParameter record);

    int insertSelective(SysParameter record);

    List<SysParameter> selectByExample(SysParameterExample example);

    SysParameter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByPrimaryKeySelective(SysParameter record);

    int updateByPrimaryKey(SysParameter record);
}