package com.huanletao.huanletao.controller;


import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebOrder;
import com.huanletao.huanletao.service.api.OrderService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 9:36
 * Description:订单信息数据控制器，
 */@RestController
@RequestMapping("order")
public class OrderController {

     @Autowired
     private OrderService orderService;

     //查询所有数据信息，
    @GetMapping("findAll")
    public List<WebOrder> findAll(){
       return orderService.findAll();
    }

    @GetMapping("delete")
    public ResponseObject deleteOrder(int[] ids){
        orderService.deleteOrder(ids);
        return ResponseObject.success(ResponseEnum.DELETESUCCESS);
    }

}
