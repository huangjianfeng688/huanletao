package com.huanletao.huanletao.dto;

import com.huanletao.huanletao.tenum.ResponseEnum;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 19:01
 * Description: 结果信息实体类。200 表示成功，400 表示出错。
 */
public class ResponseObject implements Serializable {
    private int StatusCode;
    private String message;
    private Object data;

    //失败。
    public static ResponseObject fail(int code, String message) {
        return new ResponseObject(code,message);
    }

    //使用枚举
    public static ResponseObject fail(ResponseEnum responseEnum){
        return new ResponseObject(responseEnum.getCode(), responseEnum.getMessage());
    }

    public Object getData() {
        return data;
    }

    public ResponseObject(int statusCode, String message) {
        StatusCode = statusCode;
        this.message = message;

    }

    public ResponseObject() {
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static ResponseObject success(int statusCode, String message){
        return new ResponseObject(statusCode,message);
    }

    //使用枚举
    public static ResponseObject success(ResponseEnum responseEnum){
        return new ResponseObject(responseEnum.getCode(), responseEnum.getMessage());
    }

    public ResponseObject setData(Object data){
        this.data = data;
        return this;
    }

}
