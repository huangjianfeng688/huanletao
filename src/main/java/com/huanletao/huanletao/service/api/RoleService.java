package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.SysRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/27
 * @Time: 22:05
 * Description:
 */
public interface RoleService {

    List<SysRole> findAll();

    void addSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);

    SysRole findOne(Integer id);
}
