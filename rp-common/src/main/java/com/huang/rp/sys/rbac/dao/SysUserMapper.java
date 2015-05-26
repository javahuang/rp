package com.huang.rp.sys.rbac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huang.rp.common.persistence.MyBatisRepository;
import com.huang.rp.sys.rbac.domain.SysUser;
import com.huang.rp.sys.rbac.domain.SysUserExample;

@MyBatisRepository
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    /**查询用户权限*/
    List<Map> selectUserPermissionByid(@Param("userId") Long userId);
    /**查询用户角色*/
    List<Map> selectUserRoleByid(@Param("userId") Long userId);
}