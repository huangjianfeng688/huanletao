package com.huanletao.huanletao.exception;

import com.huanletao.huanletao.contants.CommonContants;
import com.huanletao.huanletao.dto.ResponseObject;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/22
 * Time: 14:14
 * Description:对异常信息进行处理
 */@ControllerAdvice
public class HuanletaoExceptionHandler {

    //对自定义异常进行处理

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseObject error(HuanletaoException e, Model model){
        //如果出现异常
        //IncorrectCredentialsException incorrectCredentialsException = null;
//        if (incorrectCredentialsException instanceof e){
//             model.addAttribute("message",e.getMessage());
//        }
        //返回到逻辑视图
        return ResponseObject.fail(CommonContants.FAIL_CODE,e.getMessage());
    }

    //登录异常处理器。
}
