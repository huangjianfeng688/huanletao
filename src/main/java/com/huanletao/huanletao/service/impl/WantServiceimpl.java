package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.entity.WebWant;
import com.huanletao.huanletao.entity.WebWantExample;
import com.huanletao.huanletao.mapper.WebGoodDescMapper;
import com.huanletao.huanletao.mapper.WebUserMapper;
import com.huanletao.huanletao.mapper.WebWantMapper;
import com.huanletao.huanletao.service.api.WantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/4
 * @Time: 19:03
 * Description:
 */@Service
public class WantServiceimpl implements WantService {
     @Autowired
     private WebUserMapper webUserMapper;
     @Autowired
     private WebGoodDescMapper webGoodDescMapper;
     @Autowired
     private WebWantMapper webWantMapper;

     //查询自己想要的商品。
    @Override
    public List<WebGoodDesc> findMyWants(String username) {

        WebUser user = webUserMapper.findOneByUserCode(username);

       return webGoodDescMapper.findMyWants(user.getUserid());
    }

    //取消想要
    @Override
    public void removeWant(int goodid, String username) {

        WebUser user = webUserMapper.findOneByUserCode(username);

        WebWantExample example = new WebWantExample();
        WebWantExample.Criteria criteria = example.createCriteria();
        criteria.andGoodidEqualTo(goodid);
        criteria.andUseridEqualTo(user.getUserid());

        webWantMapper.deleteByExample(example);

    }

    //保存一个我想要的商品信息。
    @Override
    public void save(int goodid, String username) {
        WebUser user = webUserMapper.findOneByUserCode(username);
        WebWant webWant = new WebWant();
        webWant.setGoodid(goodid);
        webWant.setUserid(user.getUserid());


        webWantMapper.insert(webWant);

    }
}
