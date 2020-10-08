package com.huanletao.huanletao.dto;

import com.huanletao.huanletao.entity.SysRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/10/8
 * @Time: 15:15
 * Description:
 */
public class RoleMenuGroupDTO {
    private String id;
    private SysRole sysRole;
    private List<Integer> menuIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "RoleMenuGroupDTO{" +
                "id='" + id + '\'' +
                ", sysRole=" + sysRole +
                ", menuIds=" + menuIds +
                '}';
    }
}
