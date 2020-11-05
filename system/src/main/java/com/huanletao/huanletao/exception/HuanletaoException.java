package com.huanletao.huanletao.exception;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/22
 * Time: 14:11
 * Description:自定义异常类
 */
public class HuanletaoException extends RuntimeException{
    private String message;

    //有参构造方法
    public HuanletaoException(String message) {
        this.message = message;
    }

    public HuanletaoException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
