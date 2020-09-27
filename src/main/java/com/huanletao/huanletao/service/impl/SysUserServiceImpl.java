package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.entity.SysUser;
import com.huanletao.huanletao.mapper.SysUserMapper;
import com.huanletao.huanletao.service.api.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/27
 * @Time: 21:24
 * Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAllSysUser() {
        return sysUserMapper.selectByExample(null);
    }

    @Override
    public void addSysUser(SysUser sysUser) {
        sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public int updateSysUser(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
