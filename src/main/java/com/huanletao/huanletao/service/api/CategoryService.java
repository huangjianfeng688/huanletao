package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebCategory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/28
 * @Time: 11:30
 * Description:
 */
public interface CategoryService {

    //查询所有数据、
    List<WebCategory> findAll();

    //保存数据
    void save(WebCategory webCategory);

    //删除分类
    void delete(int[] ids);
}
