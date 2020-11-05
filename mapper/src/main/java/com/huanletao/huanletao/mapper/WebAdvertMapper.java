package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebAdvert;
import com.huanletao.huanletao.entity.WebAdvertExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebAdvertMapper {
    int countByExample(WebAdvertExample example);

    int deleteByExample(WebAdvertExample example);

    int deleteByPrimaryKey(Integer advertid);

    int insert(WebAdvert record);

    int insertSelective(WebAdvert record);

    List<WebAdvert> selectByExample(WebAdvertExample example);

    WebAdvert selectByPrimaryKey(Integer advertid);

    int updateByExampleSelective(@Param("record") WebAdvert record, @Param("example") WebAdvertExample example);

    int updateByExample(@Param("record") WebAdvert record, @Param("example") WebAdvertExample example);

    int updateByPrimaryKeySelective(WebAdvert record);

    int updateByPrimaryKey(WebAdvert record);
}