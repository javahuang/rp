package com.huang.rp.sys.rbac.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.sys.rbac.domain.SysPermission;
import com.huang.rp.sys.rbac.domain.SysPermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysPermissionMapper {
    int countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}