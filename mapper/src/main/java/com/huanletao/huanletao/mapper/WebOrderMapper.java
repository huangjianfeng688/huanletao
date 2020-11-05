package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.WebOrder;
import com.huanletao.huanletao.entity.WebOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebOrderMapper {
    int countByExample(WebOrderExample example);

    int deleteByExample(WebOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(WebOrder record);

    int insertSelective(WebOrder record);

    List<WebOrder> selectByExample(WebOrderExample example);

    WebOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") WebOrder record, @Param("example") WebOrderExample example);

    int updateByExample(@Param("record") WebOrder record, @Param("example") WebOrderExample example);

    int updateByPrimaryKeySelective(WebOrder record);

    int updateByPrimaryKey(WebOrder record);

    List<WebOrder> findMyOrders(int userid);

    List<WebOrder> findOrders();
}