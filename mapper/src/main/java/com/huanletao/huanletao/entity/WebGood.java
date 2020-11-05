package com.huanletao.huanletao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class WebGood implements Serializable {
    private Integer goodid;

    private Integer userid;

    private String goodname;

    private String username;

    private String catename;

    private String price;

    private Integer categoryid;

    private String status;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    @Override
    public String toString() {
        return "WebGood{" +
                "goodid=" + goodid +
                ", userid=" + userid +
                ", goodname='" + goodname + '\'' +
                ", username='" + username + '\'' +
                ", catename='" + catename + '\'' +
                ", price=" + price +
                ", categoryid=" + categoryid +
                ", status='" + status + '\'' +
                '}';
    }
}