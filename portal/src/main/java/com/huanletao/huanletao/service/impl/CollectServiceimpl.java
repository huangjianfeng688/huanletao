package com.huanletao.huanletao.service.impl;


import com.huanletao.huanletao.entity.WebCollect;
import com.huanletao.huanletao.entity.WebCollectExample;
import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.mapper.WebCollectMapper;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import com.huanletao.huanletao.mapper.WebUserMapper;
import com.huanletao.huanletao.service.api.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/4
 * @Time: 16:01
 * Description:
 */@Service
public class CollectServiceimpl implements CollectService {
     @Autowired
     private WebGoodDescMapper webGoodDescMapper;
     @Autowired
     private WebUserMapper webUserMapper;
     @Autowired
     private WebCollectMapper webCollectMapper;

     //查询我收藏的商品信息。
     @Override
    public List<WebGoodDesc> findMyCollect(String username) {
         WebUser user = webUserMapper.findOneByUserCode(username);
         return webGoodDescMapper.findMyCollect(user.getUserid());
    }

    //移除我收藏的商品信息。
    @Override
    public void removeCollect(int goodid) {
        WebCollectExample example = new WebCollectExample();
        WebCollectExample.Criteria criteria = example.createCriteria();
        criteria.andGoodidEqualTo(goodid);
        webCollectMapper.deleteByExample(example);
    }

    //添加我的收藏。
    @Override
    public void save(int goodid, String usercode) {
        WebUser user = webUserMapper.findOneByUserCode(usercode);
        WebCollect cllect = new WebCollect();
        cllect.setGoodid(goodid);
        cllect.setUserid(user.getUserid());

        webCollectMapper.insert(cllect);
    }
}
