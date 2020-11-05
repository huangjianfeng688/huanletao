package com.huanletao.huanletao.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕
 * @Date: 2020/10/8
 * @Time: 14:31
 * Description:
 */
public class MenuOptionVO {
    private String id;
    private String text;

    public MenuOptionVO() {
    }

    public MenuOptionVO(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MenuOptionVO{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
