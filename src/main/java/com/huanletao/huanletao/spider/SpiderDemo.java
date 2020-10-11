package com.huanletao.huanletao.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huanletao.huanletao.dto.RequestParam;
import com.huanletao.huanletao.util.HttpClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/10/11
 * @Time: 13:54
 * Description:
 */
public class SpiderDemo {

    public static void main(String[] args) {
        String param = RequestParam.buildParam(1, 10);
        String response = HttpClient.sendHttps("https://api.youzixy.com/ebapi/store_api/get_product_list",param);

       // System.out.println(response);

        JSONObject jsonObject = JSON.parseObject(response);

        String data = jsonObject.getString("data");
        JSONObject jsonObject1 = JSON.parseObject(data);
        String list = jsonObject1.getString("list");

        JSONArray array = JSON.parseArray(list);

        System.out.println(array.size());
        System.out.println(array);

    }
}
