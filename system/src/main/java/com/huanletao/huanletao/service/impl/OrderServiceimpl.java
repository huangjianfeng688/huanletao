package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.entity.WebOrder;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import com.huanletao.huanletao.mapper.WebOrderMapper;
import com.huanletao.huanletao.mapper.WebUserMapper;
import com.huanletao.huanletao.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 9:39
 * Description:
 */@Service
public class OrderServiceimpl implements OrderService {
     @Autowired
     private WebOrderMapper webOrderMapper;
     @Autowired
     private WebUserMapper webUserMapper;
     @Autowired
     private WebGoodDescMapper webGoodDescMapper;

     //管理员查询所有的订单数据。
    @Override
    public List<WebOrder> findAll() {
        return webOrderMapper.findOrders();
    }

    //查询有我的订单数据
    @Override
    public List<WebOrder> findMyOrders(String username) {

        WebUser user = webUserMapper.findOneByUserCode(username);

        return webOrderMapper.findMyOrders(user.getUserid());
    }

    //修改订单状态
    @Override
    public void updateOrder(int orderid, int status) {
        WebOrder webOrder = webOrderMapper.selectByPrimaryKey(orderid);
        webOrder.setStatus(status+"");

        System.out.println("status = " + status);
        //修改订单状态。
        webOrderMapper.updateByPrimaryKey(webOrder);

        //修改商品状态
        WebGoodDesc webGoodDesc = webGoodDescMapper.selectByPrimaryKey(webOrder.getGoodid());
        if (status==1){
            webGoodDesc.setStatus(status+"");
        }
        if (status==2){
            webGoodDesc.setStatus("0");
        }

        //将修改结果保存到数据库中。
        webGoodDescMapper.updateByPrimaryKey(webGoodDesc);
    }

    //管理员删除订单数据。
    @Override
    public void deleteOrder(int[] ids) {
        for (int id : ids) {
            webOrderMapper.deleteByPrimaryKey(id);
        }
    }


}
