package com.huanletao.huanletao.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.service.api.UserServices;
import com.huanletao.huanletao.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 16:28
 * Description:用户控制器
 */
@RestController
@RequestMapping("user")
public class UserController {
     @Autowired
    private UserServices userServices;
     @Autowired
     private SmsUtils smsUtils;

     @Autowired
     private HttpSession session;

    @Value("${templateCode}")
    private String templateCode;

     //查询所有用户数据
    @GetMapping("findAll")
    public List<WebUser> findAll(){
        return userServices.findAll();
    }

    //删除用户信息，
    @GetMapping("delete")
    public ResponseObject deleteUser(int[] ids){
        System.out.println("ids = " + ids);
        try {
            userServices.delete(ids);
            return new ResponseObject(200,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseObject(400,"删除失败");
        }
    }

    //搜索用户信息，
    @GetMapping("search")
    public List<WebUser> search(String keyword){
        return userServices.search(keyword);
    }


    //保存用户注册信息，
    @PostMapping("register")
    public ResponseObject register(@RequestBody WebUser user){
            userServices.save(user);
            return new ResponseObject(200,"注册成功");
    }

    //发送短信验证码
    @GetMapping("sendCode")
    public ResponseObject sendCode(String phone, HttpSession session) {
        //生成随机的6位数，
        int code = (int)((Math.random()*9+1)*100000);
        Map smCode = new HashMap();
        smCode.put("code",code);
        String string = JSON.toJSONString(smCode);
        //同时存到session中。
        session.setAttribute("code",123456);
        try {
            smsUtils.sendSms(phone,"欢乐淘","SMS_181867229",string);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new ResponseObject(200,"发送验证成功");
    }


    //用户登录
    @GetMapping("login")
    public ResponseObject userlogin(String username, String password){
        //通过用户名和密码，查询一个用户信息。
        WebUser user = userServices.userLogin(username,password);
        if (user==null){
            //查询不到。登录失败。
           return new ResponseObject(4000,"用户名或者密码错误");
        }else{
            //将用户登录的信息存到session中。保存在服务端。
            session.setAttribute(username,user);

            //返回登录成功信息。
          return   new ResponseObject(user.getUserid(),"success");
        }
    }

    //用户登出的方法。
    @GetMapping("logout")
    public ResponseObject userlogout(String username){
        session.removeAttribute(username);
        return new ResponseObject(200,"success");
    }
}
