package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.entity.WebGoodDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebGoodDescMapper {
    int countByExample(WebGoodDescExample example);

    int deleteByExample(WebGoodDescExample example);

    int deleteByPrimaryKey(Integer goodid);

    int insert(WebGoodDesc record);

    int insertSelective(WebGoodDesc record);

    List<WebGoodDesc> selectByExampleWithBLOBs(WebGoodDescExample example);

    List<WebGoodDesc> selectByExample(WebGoodDescExample example);

    WebGoodDesc selectByPrimaryKey(Integer goodid);

    int updateByExampleSelective(@Param("record") WebGoodDesc record, @Param("example") WebGoodDescExample example);

    int updateByExampleWithBLOBs(@Param("record") WebGoodDesc record, @Param("example") WebGoodDescExample example);

    int updateByExample(@Param("record") WebGoodDesc record, @Param("example") WebGoodDescExample example);

    int updateByPrimaryKeySelective(WebGoodDesc record);

    int updateByPrimaryKeyWithBLOBs(WebGoodDesc record);

    int updateByPrimaryKey(WebGoodDesc record);

    //通过id 查询商品的详细信息。
    WebGoodDesc findGoodDescById(int goodid);

    //查询我的收藏的商品信息
    List<WebGoodDesc> findMyCollect(int userid);

    //查询我添加想要的商品信息
    List<WebGoodDesc> findMyWants(int userid);

    //查询通过审核的商品信息，将审核通过的商品显示在首页中，只显示20个最多，
    List<WebGoodDesc> findPassGood();
}