package com.huanletao.huanletao.observer.api;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/10/20
 * @Time: 21:14
 * Description:
 */
public interface Observer {

    /**
     * 发送通知。
     * @param map
     */
    void sendNotice(Map<String, String> map);
}
