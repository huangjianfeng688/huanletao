package com.huanletao.huanletao.service.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huanletao.huanletao.entity.WebGood;
import com.huanletao.huanletao.entity.WebGoodDesc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 20:17
 * Description:
 */
public interface GoodServices {

    //查询所有数据
    List<WebGood> findAll();

    //查询商品详情信息，
    WebGoodDesc findGoodDescById(int id);

    //管理员审核商品信息，
    void checkGood(int goodid, String status);

    //显示几个商品信息在首页。
    List<WebGoodDesc> showGood();

    //整理爬取的数据入库。。
    void importDataToDb(JSONArray data);
}
