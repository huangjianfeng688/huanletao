package com.huanletao.huanletao.dto;

import com.huanletao.huanletao.entity.SysMenu;
import com.huanletao.huanletao.entity.SysPermissions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/9/26
 * @Time: 11:16
 * Description: 在线用户。
 */
public class ActiveUser {

    private Integer id;

    private String username;

    private String password;

    private String mail;

    private List<SysMenu> sysMenus;

    private List<SysPermissions> sysPermissions;

    private String roleName;

    public ActiveUser() {
    }

    public ActiveUser(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public void setSysMenus(List<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }

    public List<SysPermissions> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List<SysPermissions> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "ActiveUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", sysMenus=" + sysMenus +
                ", sysPermissions=" + sysPermissions +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
