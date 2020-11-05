package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebWant;
import com.huanletao.huanletao.entity.WebWantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebWantMapper {
    int countByExample(WebWantExample example);

    int deleteByExample(WebWantExample example);

    int deleteByPrimaryKey(Integer wantid);

    int insert(WebWant record);

    int insertSelective(WebWant record);

    List<WebWant> selectByExample(WebWantExample example);

    WebWant selectByPrimaryKey(Integer wantid);

    int updateByExampleSelective(@Param("record") WebWant record, @Param("example") WebWantExample example);

    int updateByExample(@Param("record") WebWant record, @Param("example") WebWantExample example);

    int updateByPrimaryKeySelective(WebWant record);

    int updateByPrimaryKey(WebWant record);
}