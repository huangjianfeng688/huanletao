package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.ActiveUser;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.SysUser;
import com.huanletao.huanletao.service.api.SysUserService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import com.huanletao.huanletao.util.MD5Utils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/1/6
 * @Time: 15:53
 * Description:后台登录的控制器。
 */@RestController
@RequestMapping("admin")
public class AdminController {

     private static final Logger logger = Logger.getLogger(AdminController.class);

     @Resource
     private SysUserService sysUserService;

     //后台管理登录。
     @PostMapping("login")
    public ResponseObject adminLogin(String username, String password){
         //获取主题。
         Subject subject = SecurityUtils.getSubject();
         String pwd = MD5Utils.MD5Encode(password);
         AuthenticationToken token = new UsernamePasswordToken(username,pwd);
         try {
             subject.login(token);
         }catch (UnknownAccountException unknownAccountException){
             logger.warn("用户不存在");
             return ResponseObject.fail(ResponseEnum.ACCOUNTNOTEXISTS);
         }catch (IncorrectCredentialsException in){
             logger.warn("密码不正确");
             return ResponseObject.fail(ResponseEnum.PASSWORDERROR);
         }
         ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
         return ResponseObject.success(ResponseEnum.LOGINSUCCESS).setData(activeUser);
     }


     //登出，
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public ResponseObject logout(){
        Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        if (!authenticated) {
            logger.info("用户未认证。");
            return ResponseObject.fail(ResponseEnum.LOGOUTFAIL);
        }
        subject.logout();
        logger.info("登出系统成功");
        return ResponseObject.success(ResponseEnum.LOGOUTSUCCESS);
    }


    //查询所有系统用户。
    @GetMapping("findAll")
    public ResponseObject findAllSysUser(){
         List<SysUser> sysUserList = sysUserService.findAllSysUser();
         return ResponseObject.success(ResponseEnum.SELECTSUCCESS).setData(sysUserList);
    }

    //新增一个系统用户
    @PostMapping("add")
    public ResponseObject addSysUser(@RequestBody SysUser sysUser){
         sysUserService.addSysUser(sysUser);
         return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }

    //更新系统用户信息，
    @PostMapping("update")
    public ResponseObject updateSysUser(@RequestBody SysUser sysUser){
         int rows = sysUserService.updateSysUser(sysUser);
        if (rows != 1) {
            return ResponseObject.fail(ResponseEnum.UPDATEFAIL);
        }
        return ResponseObject.success(ResponseEnum.UPDATESUCCESS);
    }
}
