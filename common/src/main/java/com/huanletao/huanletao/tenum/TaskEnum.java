package com.huanletao.huanletao.tenum;

/**
 *
 * @auther: 踏雪无痕。
 * @time： 2020/09/25 11:36
 * Description：定时任务的枚举数据。
 */
public enum TaskEnum {
    STATUS_RUNNING("start","1"),
    STATUS_NOT_RUNNING("stop","0");

    private String name;
    private String value;

    TaskEnum(String name,String value){
        this.name=name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
