package com.huanletao.huanletao.entity;

public class SysPermissions {
    private Integer id;

    private String name;

    private String resources;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return "SysPermissions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resources='" + resources + '\'' +
                '}';
    }

    public void setResources(String resources) {
        this.resources = resources == null ? null : resources.trim();


    }
}