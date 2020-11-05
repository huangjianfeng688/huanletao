package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebComment;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.observer.GoodSubscribeSubject;
import com.huanletao.huanletao.service.api.CollectService;
import com.huanletao.huanletao.service.api.CommentService;
import com.huanletao.huanletao.service.api.WantService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/1/6
 * @Time: 9:51
 * Description: 商品详情页的后台控制器
 */@RestController
@RequestMapping("detail")
public class GoodDetailController {

        @Autowired
        private WantService wantService;
        @Autowired
        private CollectService collectService;
        @Autowired
        private CommentService commentService;

        @Autowired
        private HttpSession session;

        @Resource
        private GoodSubscribeSubject goodSubscribeSubject;


    private static final Logger logger = Logger.getLogger(GoodDetailController.class);

    //用户添加我的想要。
     @GetMapping("addWant")
    public ResponseObject addWant(int goodid, String username) throws GeneralSecurityException, MessagingException {

         goodSubscribeSubject.addWant(username,goodid);
       /*
         WebUser webUser = (WebUser) session.getAttribute(username);
         wantService.save(goodid,webUser.getLoginname());
         Map<String,String> map = new HashMap<>();
         //这些数据从上面查出来。查出商品所有者。
         map.put("buyer",webUser.getLoginname());
         map.put("owner","1710350112@qq.com");

         //通知所有观察者。
         super.notifyObserver(map);*/

        return ResponseObject.success(ResponseEnum.SAVESUCCESS);
     }

     //用户添加收藏商品，
    @GetMapping("addCollect")
    public ResponseObject addCollect(int goodid, String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
         collectService.save(goodid,webUser.getLoginname());
         return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }

    //显示商品的评论信息。
    @GetMapping("showComment")
    public List<WebComment> showComment(int goodid){
        logger.info("查询商品所有评论信息================");
        return commentService.findCommentByGood(goodid);
    }

    @PostMapping("reportComment")
    public ResponseObject reportComment(@RequestBody WebComment webComment , String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
         commentService.save(webComment,webUser.getLoginname());
         return ResponseObject.success(ResponseEnum.OK);
    }
}
