package com.huanletao.huanletao.entity;

import java.util.Date;

public class WebOrder {
    private Integer orderid;

    private Integer goodid;

    private String goodname;

    private Integer sellerid;

    private String sellername;

    private String buyername;

    private Integer buyerid;

    private Date createdate;

    //订单商品的价格。
    private String price;

    private String status;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getSellerid() {
        return sellerid;
    }

    public void setSellerid(Integer sellerid) {
        this.sellerid = sellerid;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    @Override
    public String toString() {
        return "WebOrder{" +
                "orderid=" + orderid +
                ", goodid=" + goodid +
                ", goodname='" + goodname + '\'' +
                ", sellerid=" + sellerid +
                ", sellername='" + sellername + '\'' +
                ", buyername='" + buyername + '\'' +
                ", buyerid=" + buyerid +
                ", createdate=" + createdate +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}