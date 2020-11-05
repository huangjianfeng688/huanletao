package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.SysPermissions;
import com.huanletao.huanletao.entity.SysPermissionsExample;
import com.huanletao.huanletao.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPermissionsMapper {
    int countByExample(SysPermissionsExample example);

    int deleteByExample(SysPermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermissions record);

    int insertSelective(SysPermissions record);

    List<SysPermissions> selectByExample(SysPermissionsExample example);

    SysPermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPermissions record, @Param("example") SysPermissionsExample example);

    int updateByExample(@Param("record") SysPermissions record, @Param("example") SysPermissionsExample example);

    int updateByPrimaryKeySelective(SysPermissions record);

    int updateByPrimaryKey(SysPermissions record);

    List<SysPermissions> findPermissionByUser(SysUser user);
}