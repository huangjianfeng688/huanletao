package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebGoodDesc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/4
 * @Time: 19:02
 * Description:
 */
public interface WantService {

    List<WebGoodDesc> findMyWants(String username);

    void removeWant(int goodid, String username);


    void save(int goodid, String zhangsan);
}
