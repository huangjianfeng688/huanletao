package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebCollect;
import com.huanletao.huanletao.entity.WebGoodDesc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/4
 * @Time: 15:35
 * Description:
 */
public interface CollectService {

    List<WebGoodDesc> findMyCollect(String username);

    void removeCollect(int goodid);

    void save(int goodid, String zhangsan);
}
