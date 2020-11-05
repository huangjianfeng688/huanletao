package com.huanletao.huanletao.entity;

public class WebComment {
    private Integer commentid;

    private Integer userid;

    private Integer goodid;

    private String username;

    private String context;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    @Override
    public String toString() {
        return "WebComment{" +
                "commentid=" + commentid +
                ", userid=" + userid +
                ", goodid=" + goodid +
                ", username='" + username + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}