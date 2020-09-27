package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebAdvert;
import com.huanletao.huanletao.entity.WebAdvertExample;
import com.huanletao.huanletao.mapper.WebAdvertMapper;
import com.huanletao.huanletao.service.api.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 14:51
 * Description:
 */@Service
public class AdvertServiceimpl implements AdvertService {
     @Autowired
     private WebAdvertMapper webAdvertMapper;

     //查找通过，启用的广告。
    @Override
    public List<WebAdvert> findEnableAdvert() {
        WebAdvertExample example = new WebAdvertExample();
        WebAdvertExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");
        return webAdvertMapper.selectByExample(example);
    }

    //查询所有广告。
    @Override
    public List<WebAdvert> findAllAdverts() {
        return webAdvertMapper.selectByExample(null);
    }

    //保存提交的广告数据
    @Override
    public void saveAdvert(WebAdvert advert) {
        //先判断是新添加还是修改。
        if (null==advert.getAdvertid()){
            //没有id就是添加。
            webAdvertMapper.insert(advert);
        }else{
            //否则就是修改。
            webAdvertMapper.updateByPrimaryKey(advert);
        }
    }

    //删除广告数据
    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            webAdvertMapper.deleteByPrimaryKey(id);
        }
    }
}
