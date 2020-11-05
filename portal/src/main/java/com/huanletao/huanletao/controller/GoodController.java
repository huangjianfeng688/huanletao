package com.huanletao.huanletao.controller;

import com.github.pagehelper.PageInfo;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebGood;
import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.service.api.GoodServices;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 20:13
 * Description:
 */@RestController
@RequestMapping("good")
public class GoodController {
     @Autowired
     private GoodServices goodServices;

     private static Logger log = Logger.getLogger(GoodController.class.getClass());

     //查询所有商品信息，
     @GetMapping("findAll")
     public List<WebGood> findAll(){
         return goodServices.findAll();
     }

     //查询商品详情信息，根据商品id，
     @GetMapping("findGoodDescById")
     public WebGoodDesc findGoodDescById(int id){
          return goodServices.findGoodDescById(id);
     }

     //管理员审核商品信息，
     @GetMapping("check")
     public ResponseObject check(int goodid, String status){
          //审核商品信息
          goodServices.checkGood(goodid,status);
          return ResponseObject.success(ResponseEnum.OK);
     }

     //显示商品信息在首页。
     @GetMapping("showGood")
     public List<WebGoodDesc> showGood(){
          System.out.println("goodServices = " + goodServices);
          return goodServices.showGood();
     }


     @GetMapping("search")
     public ResponseObject search(int page, int rows, @RequestParam(required = false)String wd ){
          PageInfo pageInfo = goodServices.search(page,rows,wd);
          return ResponseObject.success(ResponseEnum.OK).setData(pageInfo);
     }

}
