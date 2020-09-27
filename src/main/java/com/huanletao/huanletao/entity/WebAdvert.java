package com.huanletao.huanletao.entity;

public class WebAdvert {
    private Integer advertid;

    private String advertname;

    private String tarurl;

    private String picaddress;

    private String status;

    public Integer getAdvertid() {
        return advertid;
    }

    public void setAdvertid(Integer advertid) {
        this.advertid = advertid;
    }

    public String getAdvertname() {
        return advertname;
    }

    public void setAdvertname(String advertname) {
        this.advertname = advertname == null ? null : advertname.trim();
    }

    public String getTarurl() {
        return tarurl;
    }

    public void setTarurl(String tarurl) {
        this.tarurl = tarurl == null ? null : tarurl.trim();
    }

    public String getPicaddress() {
        return picaddress;
    }

    public void setPicaddress(String picaddress) {
        this.picaddress = picaddress == null ? null : picaddress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}