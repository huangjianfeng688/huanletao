package com.huanletao;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.huanletao.huanletao.entity.WebOrder;
import com.huanletao.huanletao.mapper.WebOrderMapper;
import com.huanletao.huanletao.util.SmsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/4
 * @Time: 0:55
 * Description:

 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/applicationContext.xml")
//public class sendSmsTest {
//    @Autowired
//    private SmsUtils smsUtils;
//
//    @Autowired
//    private WebOrderMapper webOrderMapper;
//
//
//    @Test
//    public void test01() throws ClientException {
//        //向阿里大于发送消息，然后通知用户。
//        Map<String,String> data = new HashMap<>();
//        data.put("phone","18207700421");
//        data.put("signName","欢乐淘");
//        data.put("templateCode","SMS_181867229");
//        //创建一个小map 存储验证码
//        Map smallMap = new HashMap<>();
//        smallMap.put("code","8886");
//        //转为json字符串
//        String s = JSON.toJSONString(smallMap);
//        data.put("param",s);
//
//        // 将大的map 转为json字符串
//        String s1 = JSON.toJSONString(data);
//
//        smsUtils.sendSms("18207700421","欢乐淘",
//                "SMS_181867229",s);
//
//    }



//    @Test
//    public void test03(){
//        List<WebOrder> myOrders = webOrderMapper.findMyOrders(7);
//        for (WebOrder myOrder : myOrders) {
//            System.out.println("myOrder = " + myOrder);
//        }
//    }
//
//    @Test
//    public void test05(){
//        int random = (int)((Math.random()*9+1)*100000);
//        System.out.println("random = " + random);
//    }
//
//}

