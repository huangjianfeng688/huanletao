package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebGood;
import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import com.huanletao.huanletao.mapper.WebGoodMapper;
import com.huanletao.huanletao.service.api.GoodServices;
import com.huanletao.huanletao.util.SolrUtil;
import com.huanletao.huanletao.util.SolrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 20:18
 * Description:
 */@Service
public class GoodServiceimpl implements GoodServices {

     @Autowired
     private WebGoodMapper webGoodMapper;
     @Autowired
     private WebGoodDescMapper webGoodDescMapper;
     @Autowired
     private SolrUtils solrUtils;

     //查询所有商品信息，
    @Override
    public List<WebGood> findAll() {
        return webGoodMapper.findGoodsAndUserCate();
    }

    //查询商品详情信息，根据id查询。
    @Override
    public WebGoodDesc findGoodDescById(int id) {
        return webGoodDescMapper.findGoodDescById(id);
    }


    //审核商品信息，
    @Override
    public void checkGood(int goodid, String status) {
        //先查出来，然后修改状态，再更新到数据库中。
        WebGood webGood = webGoodMapper.selectByPrimaryKey(goodid);

        webGood.setStatus(status);

        //如果审核的商品通过，就将它添加到索引库。
        if ("1".equals(status)){
            WebGoodDesc goodDescById = webGoodDescMapper.findGoodDescById(webGood.getGoodid());

            solrUtils.saveSolr(goodDescById);
        }

        //更新到数据库中。
        webGoodMapper.updateByPrimaryKey(webGood);

    }

    //显示几个商品信息在首页
    @Override
    public List<WebGoodDesc> showGood() {
        return webGoodDescMapper.findPassGood();
    }
}
