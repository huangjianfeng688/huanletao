package com.huanletao.huanletao.entity;

public class WebWant {
    private Integer wantid;

    private Integer goodid;

    private Integer userid;

    private String reply;

    public Integer getWantid() {
        return wantid;
    }

    public void setWantid(Integer wantid) {
        this.wantid = wantid;
    }

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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }
}