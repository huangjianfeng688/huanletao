package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebGood;
import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.entity.WebOrder;
import com.huanletao.huanletao.entity.WebUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/2
 * @Time: 11:55
 * Description: 个人中心的业务逻辑层。
 */
public interface PersonalService {

    //查询我的商品信息
    List<WebGood> findMyGood(String userCode);

    //发布新商品。
    void addGood(WebGoodDesc good, String userCode);

    //删除商品信息。
    void deleteGood(int goodid);

    //查询该商品下的买家。
    List<WebUser> findBuyers(int goodid);

    //生成订单数据，同时发送消息。
    void generateOrder(WebOrder webOrder);

    //查询我的订单数据
    List<WebOrder> findMyOrders(String sellername);
}
