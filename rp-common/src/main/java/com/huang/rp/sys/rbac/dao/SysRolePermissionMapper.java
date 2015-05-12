package com.huang.rp.sys.rbac.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.sys.rbac.domain.SysRolePermission;
import com.huang.rp.sys.rbac.domain.SysRolePermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysRolePermissionMapper {
    int countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    SysRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}