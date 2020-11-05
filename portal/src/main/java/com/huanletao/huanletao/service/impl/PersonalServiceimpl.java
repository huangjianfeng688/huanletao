package com.huanletao.huanletao.service.impl;

import com.alibaba.fastjson.JSON;
import com.huanletao.huanletao.entity.*;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import com.huanletao.huanletao.mapper.WebGoodMapper;
import com.huanletao.huanletao.mapper.WebOrderMapper;
import com.huanletao.huanletao.mapper.WebUserMapper;
import com.huanletao.huanletao.service.api.PersonalService;
import com.huanletao.huanletao.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/2
 * @Time: 11:57
 * Description:
 */@Service
public class PersonalServiceimpl implements PersonalService {
     @Autowired
     private WebGoodMapper webGoodMapper;
     @Autowired
     private WebUserMapper webUserMapper;
     @Autowired
     private WebGoodDescMapper webGoodDescMapper;
     @Autowired
     private WebOrderMapper webOrderMapper;
     @Autowired
     private SmsUtils smsUtils;

     //查找我的商品列表。
    @Override
    public List<WebGood> findMyGood(String userCode) {
        return webGoodMapper.findMyGoodByUserCode(userCode);
    }

    //发布新的商品信息。天添加sku，在添加spu表。
    @Override
    public void addGood(WebGoodDesc webGoodDesc, String userCode) {

        //然后再存入。
        webGoodDesc.setStatus("0");
        webGoodDescMapper.insert(webGoodDesc);

        //设置商品的所有者。
        WebUser oneByUserCode = webUserMapper.findOneByUserCode(userCode);

        WebGood webGood = new WebGood();
        webGood.setUsername(oneByUserCode.getUsername());
        webGood.setUserid(oneByUserCode.getUserid());

        webGood.setStatus("0");
        webGood.setCategoryid(3);
        webGood.setGoodname(webGoodDesc.getGoodname());
        webGood.setGoodid(webGoodDesc.getGoodid());
        webGood.setPrice(webGoodDesc.getPrice());
        webGood.setCategoryid(webGoodDesc.getCategoryid());
        //插入spu商品表。
        webGoodMapper.insert(webGood);


    }

    //删除商品信息。【注意】，这里要删两张表对应的数据才算删除。
    @Override
    public void deleteGood(int goodid) {
        //删除商品表的数据
        webGoodMapper.deleteByPrimaryKey(goodid);
        //删除商品描述表的数据。
        webGoodDescMapper.deleteByPrimaryKey(goodid);
    }


    //查询该商品下的买家，主表是从想要表中进行关联查询。
    @Override
    public List<WebUser> findBuyers(int goodid) {
        return webUserMapper.findBuyers(goodid);
    }

    //生成订单数据，同时发送通知给买家。同时设置商品的状态为正在交易中。
    @Override
    public void generateOrder(WebOrder webOrder) {
        webOrder.setCreatedate(new Date());
        webOrder.setStatus("0");
        //先插入数据。
        webOrderMapper.insert(webOrder);

        //查询出来，再进行修改
        WebGoodDesc webGoodDesc = webGoodDescMapper.selectByPrimaryKey(webOrder.getGoodid());
        webGoodDesc.setStatus("2");
        webGoodDescMapper.updateByPrimaryKey(webGoodDesc);


        //拿到买家的号码。然后发送通知。
        Integer buyerid = webOrder.getBuyerid();
        WebUser webUser = webUserMapper.selectByPrimaryKey(buyerid);

        //构造发送的code。
        Map code = new HashMap<>();
        code.put("code","123456");
        String toJSONString = JSON.toJSONString(code);
        //《终身成长》

       /* //拿到买家的号码。然后发送通知。
        try {
          //  smsUtils.sendSms("18207700421","欢乐淘",
          //          "SMS_181867229",toJSONString);
        } catch (ClientException e) {
            e.printStackTrace();
        }*/
    }

    //查询我的订单数据
    @Override
    public List<WebOrder> findMyOrders(String sellername) {

        WebUser webUser = webUserMapper.findOneByUserCode(sellername);

        WebOrderExample example = new WebOrderExample();
        WebOrderExample.Criteria criteria = example.createCriteria();
        criteria.andSelleridEqualTo(webUser.getUserid());


        WebOrderExample.Criteria criteria1 = example.createCriteria();
        criteria1.andBuyeridEqualTo(webUser.getUserid());
                example.or(criteria1);

        return webOrderMapper.selectByExample(example);
    }
}
