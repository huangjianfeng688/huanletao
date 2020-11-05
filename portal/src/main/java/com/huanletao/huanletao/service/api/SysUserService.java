package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.SysUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/27
 * @Time: 21:24
 * Description:
 */
public interface SysUserService {

    List<SysUser> findAllSysUser();

    void addSysUser(SysUser sysUser);

    int updateSysUser(SysUser sysUser);
}
