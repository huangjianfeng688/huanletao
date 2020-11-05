package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebGood;
import com.huanletao.huanletao.entity.WebGoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebGoodMapper {
    int countByExample(WebGoodExample example);

    int deleteByExample(WebGoodExample example);

    int deleteByPrimaryKey(Integer goodid);

    int insert(WebGood record);

    int insertSelective(WebGood record);

    List<WebGood> selectByExample(WebGoodExample example);

    WebGood selectByPrimaryKey(Integer goodid);

    int updateByExampleSelective(@Param("record") WebGood record, @Param("example") WebGoodExample example);

    int updateByExample(@Param("record") WebGood record, @Param("example") WebGoodExample example);

    int updateByPrimaryKeySelective(WebGood record);

    int updateByPrimaryKey(WebGood record);

    //查询商品信息，发布人信息，关联的分类信息
    List<WebGood> findGoodsAndUserCate(String wd);

    //根据当前登录的用户，查询自己的商品信息。
    List<WebGood> findMyGoodByUserCode(String userCode);

    //添加商品的方法
    void addGood(WebGood webGood);
}