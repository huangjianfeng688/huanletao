package com.huanletao.huanletao.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class WebGoodDesc implements Serializable {

    private Long id;

    @Field("item_goodid")
    private Integer goodid;

    @Field("item_title")
    private String goodname;

    @Field("item_price")
    private String price;

    @Field("item_image")
    private String pictures;

    @Field("item_contact")
    private String contact;

    @Field("item_address")
    private String address;

    @Field("item_status")
    private String status;

    private Integer goodnumber;

    private String old;

    @Field("item_desc")
    private String gooddesc;

    private int categoryid;

    @Field("item_category")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
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

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getGoodnumber() {
        return goodnumber;
    }

    public void setGoodnumber(Integer goodnumber) {
        this.goodnumber = goodnumber;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old == null ? null : old.trim();
    }

    public String getGooddesc() {
        return gooddesc;
    }

    public void setGooddesc(String gooddesc) {
        this.gooddesc = gooddesc == null ? null : gooddesc.trim();
    }

    @Override
    public String toString() {
        return "WebGoodDesc{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", goodname='" + goodname + '\'' +
                ", price=" + price +
                ", pictures='" + pictures + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", goodnumber=" + goodnumber +
                ", old='" + old + '\'' +
                ", gooddesc='" + gooddesc + '\'' +
                ", categoryid=" + categoryid +
                ", category='" + category + '\'' +
                '}';
    }
}