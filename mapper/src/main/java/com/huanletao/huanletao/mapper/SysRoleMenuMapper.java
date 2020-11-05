package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.dto.RoleMenuGroupDTO;
import com.huanletao.huanletao.entity.SysRoleMenu;
import com.huanletao.huanletao.entity.SysRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper {
    int countByExample(SysRoleMenuExample example);

    int deleteByExample(SysRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    SysRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuExample example);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    /**
     *  批量插入数据
     * @param roleMenuGroup
     */
    void batchInsert(RoleMenuGroupDTO roleMenuGroup);
}