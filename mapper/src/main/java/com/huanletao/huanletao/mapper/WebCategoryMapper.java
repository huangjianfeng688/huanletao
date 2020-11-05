package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebCategory;
import com.huanletao.huanletao.entity.WebCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebCategoryMapper {
    int countByExample(WebCategoryExample example);

    int deleteByExample(WebCategoryExample example);

    int deleteByPrimaryKey(Integer categoryid);

    int insert(WebCategory record);

    int insertSelective(WebCategory record);

    List<WebCategory> selectByExample(WebCategoryExample example);

    WebCategory selectByPrimaryKey(Integer categoryid);

    int updateByExampleSelective(@Param("record") WebCategory record, @Param("example") WebCategoryExample example);

    int updateByExample(@Param("record") WebCategory record, @Param("example") WebCategoryExample example);

    int updateByPrimaryKeySelective(WebCategory record);

    int updateByPrimaryKey(WebCategory record);
}