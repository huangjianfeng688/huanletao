package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebCollect;
import com.huanletao.huanletao.entity.WebCollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebCollectMapper {
    int countByExample(WebCollectExample example);

    int deleteByExample(WebCollectExample example);

    int deleteByPrimaryKey(Integer collectid);

    int insert(WebCollect record);

    int insertSelective(WebCollect record);

    List<WebCollect> selectByExample(WebCollectExample example);

    WebCollect selectByPrimaryKey(Integer collectid);

    int updateByExampleSelective(@Param("record") WebCollect record, @Param("example") WebCollectExample example);

    int updateByExample(@Param("record") WebCollect record, @Param("example") WebCollectExample example);

    int updateByPrimaryKeySelective(WebCollect record);

    int updateByPrimaryKey(WebCollect record);
}