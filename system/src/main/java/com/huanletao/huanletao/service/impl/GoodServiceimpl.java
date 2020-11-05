package com.huanletao.huanletao.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huanletao.huanletao.entity.WebGood;
import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.mapper.WebCategoryMapper;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import com.huanletao.huanletao.mapper.WebGoodMapper;
import com.huanletao.huanletao.service.api.GoodServices;
import com.huanletao.huanletao.util.RedisUtils;
import com.huanletao.huanletao.common.SolrUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     private WebCategoryMapper webCategoryMapper;
     @Autowired
     private SolrUtils solrUtils;
     @Autowired
     private RedisUtils redisUtils;

     private static final Logger log = Logger.getLogger(GoodServiceimpl.class);

     //查询所有商品信息，
    @Override
    public List<WebGood> findAll() {
        PageHelper.startPage(0,20);
        PageInfo<WebGood> webGoodPageInfo = new PageInfo<>(webGoodMapper.findGoodsAndUserCate(""));
        return webGoodPageInfo.getList();
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

        List<WebGoodDesc> goods = (List<WebGoodDesc>) redisUtils.get("goods");
        if (goods==null){
            redisUtils.set("goods",webGoodDescMapper.findPassGood());
            return (List<WebGoodDesc>) redisUtils.get("goods");
        }
        return goods;
    }

    /**
     * 整理思路：爬取网站数据。
     *   导入商品表和商品详情表。
     * @param data
     */
    @Override
    public void importDataToDb(JSONArray data) {

        for (int i = 0; i < data.size(); i++) {
            JSONObject datum = (JSONObject) data.get(i);
            String image = datum.getString("image");
            String store_info = datum.getString("store_info");
            String price = datum.getString("price");
            String store_name = datum.getString("store_name");
            String slogan = datum.getString("slogan");
            Integer userId = randomUser();

            WebGood webGood = new WebGood();
            webGood.setCategoryid(11);
            webGood.setPrice(price);
            webGood.setGoodname(store_name);
            webGood.setStatus("1");
            webGood.setUserid(userId);

            webGoodMapper.addGood(webGood);

            WebGoodDesc webGoodDesc = new WebGoodDesc();
            webGoodDesc.setId(Long.parseLong(webGood.getGoodid().toString()));
            webGoodDesc.setCategoryid(11);
            webGoodDesc.setPrice(price);
            webGoodDesc.setGoodname(store_name);
            webGoodDesc.setGooddesc(store_info);
            webGoodDesc.setAddress(slogan);
            webGoodDesc.setStatus("1");
            webGoodDesc.setPictures(image);
            webGoodDesc.setStatus("1");
            webGoodDescMapper.insert(webGoodDesc);

            log.info("第"+i+"导入成功一个");

        }
    }

    private Integer randomUser() {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(27);
        userIds.add(20);
        userIds.add(26);
        userIds.add(22);
        userIds.add(25);
        userIds.add(29);
        userIds.add(28);

        Random random = new Random();
        int index = random.nextInt(userIds.size());

       return userIds.get(index);
    }

    @PostConstruct
    private void CacheInit(){
        List<WebGoodDesc> webGoodDescs = webGoodDescMapper.findPassGood();
        List<WebGood> webGoods = webGoodMapper.selectByExample(null);
        redisUtils.set("goods",webGoodDescs);
        redisUtils.set("cate",webCategoryMapper.selectByExample(null));
    }


    @Override
    public PageInfo search(int page, int rows, String wd) {

        log.info("wd = "+wd);

        PageHelper.startPage(page,rows);
        List<WebGood> goodsAndUserCate = webGoodMapper.findGoodsAndUserCate(wd);

        PageInfo pageInfo = new PageInfo(goodsAndUserCate);

        return pageInfo;
    }
}
