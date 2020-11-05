package com.huanletao.huanletao.entity;

import java.io.Serializable;

public class WebCategory implements Serializable {
    private Integer categoryid;

    private String catename;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename == null ? null : catename.trim();
    }


    @Override
    public String toString() {
        return "WebCategory{" +
                "categoryid=" + categoryid +
                ", catename='" + catename + '\'' +
                '}';
    }
}