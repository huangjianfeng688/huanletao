package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebAdvert;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 14:50
 * Description:
 */
public interface AdvertService {

    //查询启用的广告，进行前台显示，
    List<WebAdvert> findEnableAdvert();

    //后台查询所有广告。
    List<WebAdvert> findAllAdverts();

    //提交数据到后台数据库。
    void saveAdvert(WebAdvert advert);

    //删除广告数据。
    void delete(int[] ids);
}
