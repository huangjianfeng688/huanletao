package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.SysRole;
import com.huanletao.huanletao.mapper.SysRoleMapper;
import com.huanletao.huanletao.service.api.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/27
 * @Time: 22:05
 * Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.selectByExample(null);
    }

    @Override
    public void addSysRole(SysRole sysRole) {
        sysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public void updateSysRole(SysRole sysRole) {
       sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public SysRole findOne(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }
}
