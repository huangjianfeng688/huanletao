package com.huanletao.huanletao.controller;


import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.*;
import com.huanletao.huanletao.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/2
 * @Time: 11:42
 * Description: 个人中心的控制层。
 */@RestController
@RequestMapping("personal")
public class PersonalController {

     @Autowired
     private UserServices userServices;
     @Autowired
     private PersonalService personalService;
     @Autowired
     private OrderService orderService;
     @Autowired
     private CollectService collectService;
     @Autowired
     private WantService wantService;
     @Autowired
     private HttpSession session;

    //根据用户名查找一个用户信息，。
    @GetMapping("findByUserCode")
    public WebUser findByUserCode(String username){
        WebUser onlineName = (WebUser) session.getAttribute(username);
      return userServices.findOneByUserCode(username);
    }

    //更新用户信息。
    @PostMapping("update")
    public ResponseObject updateUser(@RequestBody WebUser user){
        userServices.updateUser(user);
        return new ResponseObject(200,"success,修改成功");
    }

    //查找我的商品信息。
    @GetMapping("findMyGood")
    public List<WebGood> findMyGood(String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
        return personalService.findMyGood(webUser.getLoginname());
    }

    //添加商品信息。
    @PostMapping("addGood")
    public ResponseObject addGood(String username , @RequestBody WebGoodDesc webGoodDesc){

        WebUser webUser = (WebUser) session.getAttribute(username);
        personalService.addGood(webGoodDesc,webUser.getLoginname());
        return new ResponseObject(200,"商品发布成功");
    }

    //删除商品信息。
    @GetMapping("deleteGood")
    public ResponseObject deleteGood(int goodid){
        personalService.deleteGood(goodid);
        return new ResponseObject(200,"success");
    }

    //查询买家
    @GetMapping("findBuyer")
    public List<WebUser> findBuyers(int goodid){
      return   personalService.findBuyers(goodid);
    }

    //生成订单数据。
    @PostMapping("generateOrder")
    public ResponseObject generateOrder(@RequestBody WebOrder webOrder){

        personalService.generateOrder(webOrder);
        return new ResponseObject(200,"success");
    }

    //查询我的订单数据
    @GetMapping("findMyOrders")
    public List<WebOrder> findMyOrders(String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
       return orderService.findMyOrders(webUser.getLoginname());
    }

    //修改订单状态。
    @GetMapping("updateOrder")
    public ResponseObject updateOrder(int orderid, int status){
        orderService.updateOrder(orderid,status);
        return new ResponseObject(200,"success");
    }

    //查询我的收藏商品
    @GetMapping("findMyCollect")
    public List<WebGoodDesc> findMyCollect(String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
        return collectService.findMyCollect(webUser.getLoginname());
    }

    //移除我收藏的商品。
    @GetMapping("removeCollect")
    public ResponseObject removeCollect(int goodid){
        collectService.removeCollect(goodid);
        return new ResponseObject(200,"success");
    }

    //查询商品信息。
    @GetMapping("findMyWants")
    public List<WebGoodDesc> findMyWants(String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
        return wantService.findMyWants(webUser.getLoginname());
    }


    //取消想要
    @GetMapping("removeWant")
    public ResponseObject removeWant(int goodid){
        String username = (String) session.getAttribute("onlineUser");
        wantService.removeWant(goodid,username);
        return new ResponseObject(200,"success");
    }

}
