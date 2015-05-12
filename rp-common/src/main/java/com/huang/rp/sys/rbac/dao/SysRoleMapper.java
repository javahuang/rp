package com.huang.rp.sys.rbac.dao;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.sys.rbac.domain.SysRole;
import com.huang.rp.sys.rbac.domain.SysRoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}