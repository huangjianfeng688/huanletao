package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.SysDict;
import com.huanletao.huanletao.entity.SysDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper {
    int countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    List<SysDict> selectByExample(SysDictExample example);

    SysDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);
}