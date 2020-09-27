package com.huanletao.huanletao.tenum;

import com.huanletao.huanletao.contants.CommonContants;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/27
 * @Time: 21:31
 * Description:login
 */
public enum ResponseEnum {

    LOGINSUCCESS(CommonContants.SUCCESS_CODE,"登录系统成功"),
    ACCOUNTNOTEXISTS(CommonContants.FAIL_CODE,"用户不存在"),
    PASSWORDERROR(CommonContants.FAIL_CODE,"密码错误"),
    LOGOUTSUCCESS(CommonContants.SUCCESS_CODE,"退出系统成功"),
    LOGOUTFAIL(CommonContants.FAIL_CODE,"退出系统失败"),

    SAVESUCCESS(CommonContants.SUCCESS_CODE,"保存成功"),
    SAVEFAIL(CommonContants.FAIL_CODE,"保存失败"),

    DELETESUCCESS(CommonContants.SUCCESS_CODE,"删除成功"),
    DELETEFAIL(CommonContants.FAIL_CODE,"删除失败"),

    SELECTSUCCESS(CommonContants.SUCCESS_CODE,"查询成功"),
    SELECTFAIL(CommonContants.FAIL_CODE,"查询失败"),

    UPDATESUCCESS(CommonContants.SUCCESS_CODE,"更新成功"),
    UPDATEFAIL(CommonContants.FAIL_CODE,"更新失败"),

    UPLOADSUCCESS(CommonContants.SUCCESS_CODE,"上传成功");

    private Integer code;
    private String message;

    private ResponseEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
