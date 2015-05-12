package com.huang.rp.web.sys.rbac.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.web.sys.rbac.domain.SysResource;
import com.huang.rp.web.sys.rbac.domain.SysResourceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysResourceMapper {
    int countByExample(SysResourceExample example);

    int deleteByExample(SysResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    List<SysResource> selectByExample(SysResourceExample example);

    SysResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
}