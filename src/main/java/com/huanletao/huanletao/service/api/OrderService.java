package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 9:38
 * Description:
 */
public interface OrderService {


    List<WebOrder> findAll();

    List<WebOrder> findMyOrders(String loginname);

    void updateOrder(int orderid, int status);

    void deleteOrder(int[] ids);
}
