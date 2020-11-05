package com.huanletao.huanletao.exception;

import com.huanletao.huanletao.contants.CommonContants;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
    public ResponseObject hanle(RuntimeException e){
        //如果出现异常
        if (e instanceof IncorrectCredentialsException){
            return ResponseObject.fail(ResponseEnum.PASSWORDERROR);
        }

        if (e instanceof UnknownAccountException){
            return ResponseObject.fail(ResponseEnum.ACCOUNTNOTEXISTS);
        }
        if(e instanceof HuanletaoException){
            //其他业务异常
            return ResponseObject.fail(CommonContants.FAIL_CODE,e.getMessage());
        }
       return null;
    }

    //登录异常处理器。
}
