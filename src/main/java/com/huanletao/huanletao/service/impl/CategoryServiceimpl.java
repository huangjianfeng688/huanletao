package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.WebCategory;
import com.huanletao.huanletao.mapper.WebCategoryMapper;
import com.huanletao.huanletao.service.api.CategoryService;
import com.huanletao.huanletao.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/28
 * @Time: 11:31
 * Description:
 */@Service
public class CategoryServiceimpl implements CategoryService {
     @Autowired
     private WebCategoryMapper webCategoryMapper;
     @Autowired
     private RedisUtils redisUtils;


     //查询所有数据。
    @Override
    public List<WebCategory> findAll() {
        List<WebCategory> cate = (List<WebCategory>) redisUtils.get("cate");

        if (cate==null){
            redisUtils.set("cate",webCategoryMapper.selectByExample(null));
            return (List<WebCategory>) redisUtils.get("cate");
        }

        return cate;
    }

    //保存修改或者添加的分类信息，
    @Override
    public void save(WebCategory webCategory) {

        //先删除缓存。
        redisUtils.remove("cate");

        //判断是添加还是修改，
        //id 不为空就是修改，
        if (webCategory.getCategoryid()!=null){
            webCategoryMapper.updateByPrimaryKey(webCategory);
        }else{
              //否则就是添加。
             webCategoryMapper.insert(webCategory);
        }
        redisUtils.remove("cate");
    }


    //删除分类信息，
    @Override
    public void delete(int[] ids) {
        //先删除缓存
        redisUtils.remove("cate");

        for (int id : ids) {
            webCategoryMapper.deleteByPrimaryKey(id);
        }

    }
}
