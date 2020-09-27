package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.service.api.GoodSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/5
 * @Time: 10:39
 * Description: 实现搜索功能的控制器。
 */@RestController
@RequestMapping("item")
public class GoodSearchController {

     @Autowired
     private GoodSearchService goodSearchService;

     @RequestMapping("search")
    public Map<String, Object> search(@RequestBody(required = false) Map map){
        return goodSearchService.search(map);
     }
}
