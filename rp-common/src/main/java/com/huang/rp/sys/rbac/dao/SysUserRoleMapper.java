package com.huang.rp.sys.rbac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.sys.rbac.domain.SysUserRole;
import com.huang.rp.sys.rbac.domain.SysUserRoleExample;

@MyBatisRepository
public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByExample(SysUserRoleExample example);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}