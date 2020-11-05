package com.huanletao.huanletao.observer;

import com.huanletao.huanletao.controller.GoodDetailController;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.observer.base.AbstractSubject;
import com.huanletao.huanletao.service.api.CollectService;
import com.huanletao.huanletao.service.api.CommentService;
import com.huanletao.huanletao.service.api.WantService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/10/20
 * @Time: 21:29
 * Description: 商品订阅主题。
 */
@Component
public class GoodSubscribeSubject extends AbstractSubject {

    @Autowired
    private WantService wantService;

    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(GoodSubscribeSubject.class);

    //注册观察者。
    protected GoodSubscribeSubject(){
        registerObserver(new SubscribeObserver());
        registerObserver(new GoodOwnerObserver());
    }

    public void addWant(String username,int goodid){
        WebUser webUser = (WebUser) session.getAttribute(username);
        wantService.save(goodid,webUser.getLoginname());
        Map<String,String> map = new HashMap<>();
        //这些数据从上面查出来。查出商品所有者。
        map.put("buyer",webUser.getLoginname());
        map.put("owner","1710350112@qq.com");

        logger.info("实现添加逻辑，同时唤醒通知所有观察者。");

        //通知所有观察者。
        super.notifyObserver(map);
    }

}
