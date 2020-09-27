package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.SysMenu;
import com.huanletao.huanletao.mapper.SysMenuMapper;
import com.huanletao.huanletao.service.api.MeunSevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕
 * @Date: 2020/9/27
 * @Time: 22:27
 * Description:
 */
@Service
public class MeunSeviceImpl implements MeunSevice {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findAllMenu() {
        return sysMenuMapper.selectByExample(null);
    }

    @Override
    public void addSysMenu(SysMenu sysMenu) {
        sysMenuMapper.insertSelective(sysMenu);
    }

    @Override
    public void updateSysMenu(SysMenu sysMenu) {
        sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public SysMenu findOne(Integer id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }
}
