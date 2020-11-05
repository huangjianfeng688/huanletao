package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebAdvert;
import com.huanletao.huanletao.service.api.AdvertService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.ResponseCache;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 14:47
 * Description: 轮播图 控制器
 */@RestController
@RequestMapping("advert")
public class AdvertController {
     @Autowired
    private AdvertService advertService;

     //查询启用的广告
     @GetMapping("findEnable")
    public List<WebAdvert> findEnableAdvert(){
         return advertService.findEnableAdvert();
     }

     //查询所有广告。
    @GetMapping("findAll")
    public List<WebAdvert> findAlld(){
         return advertService.findAllAdverts();
    }

    //保存新的广告信息到数据库中。
    @PostMapping("save")
    public ResponseObject saveAdvert(@RequestBody WebAdvert advert){
         advertService.saveAdvert(advert);
         return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }

    //删除广告。
    @GetMapping("delete")
    public ResponseObject deleteAdvert(int[] ids){
         advertService.delete(ids);
         return ResponseObject.success(ResponseEnum.DELETESUCCESS);
    }

}
