package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebComment;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.service.api.CollectService;
import com.huanletao.huanletao.service.api.CommentService;
import com.huanletao.huanletao.service.api.UserServices;
import com.huanletao.huanletao.service.api.WantService;

import com.huanletao.huanletao.util.MailUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        private UserServices userServices;

        @Autowired
        private HttpSession session;

    private static final Logger logger = Logger.getLogger(GoodDetailController.class);

     //用户添加我的想要。
     @GetMapping("addWant")
    public ResponseObject addMyWant(int goodid, String username) throws GeneralSecurityException, MessagingException {

         logger.info("username = " + username);
         WebUser webUser = (WebUser) session.getAttribute(username);
         wantService.save(goodid,webUser.getLoginname());

         WebUser seller = userServices.findByGoodId(goodid);
         String context ="用户："+webUser.getLoginname() + "订阅了你的宝贝。";
         MailUtils.sendSimpleMail(seller.getLoginname(),context);
         logger.info("已经发送邮箱通知宝贝主人 ---》"+seller.getUsername());

        return new ResponseObject(200,"添加想要成功");
     }

     //用户添加收藏商品，
    @GetMapping("addCollect")
    public ResponseObject addCollect(int goodid, String username){
        WebUser webUser = (WebUser) session.getAttribute(username);
         collectService.save(goodid,webUser.getLoginname());
         return new ResponseObject(200,"收藏成功");
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
         return new ResponseObject(200,"success");
    }
}
