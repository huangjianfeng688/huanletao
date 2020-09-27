package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/9/27
 * @Time: 22:26
 * Description:
 */

public interface MeunSevice {
    List<SysMenu> findAllMenu();

    void addSysMenu(SysMenu sysMenu);

    void updateSysMenu(SysMenu sysMenu);

    SysMenu findOne(Integer id);
}
