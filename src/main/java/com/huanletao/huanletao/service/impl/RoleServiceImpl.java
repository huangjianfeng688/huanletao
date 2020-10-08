package com.huanletao.huanletao.service.impl;

import com.huanletao.huanletao.dto.RoleMenuGroupDTO;
import com.huanletao.huanletao.entity.SysRole;
import com.huanletao.huanletao.entity.SysRoleMenu;
import com.huanletao.huanletao.entity.SysRoleMenuExample;
import com.huanletao.huanletao.mapper.SysRoleMapper;
import com.huanletao.huanletao.mapper.SysRoleMenuMapper;
import com.huanletao.huanletao.service.api.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.listSysRolePermissions();
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


    /**
     * 更新菜单权限，1.先判断是否是新增还是修改，
     *            2.删除当前的额关系表中的数据。
     *            3.然后再新增数据。
     * @param roleMenuGroup
     */
    @Override
    public void updateSysRoleMenus(RoleMenuGroupDTO roleMenuGroup) {

        //1.先判断是否是新增还是修改，
        SysRole sysRole = roleMenuGroup.getSysRole();
        if (StringUtils.isNotBlank(sysRole.getId().toString())) {
            //先修改角色数据。
            sysRoleMapper.updateByPrimaryKeySelective(sysRole);

            //删除关系表中该角色的数据。
            SysRoleMenuExample example = new SysRoleMenuExample();
            SysRoleMenuExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(sysRole.getId());
            sysRoleMenuMapper.deleteByExample(example);

            //2.然后再新增数据。
            sysRoleMenuMapper.batchInsert(roleMenuGroup);
            return;
        }
        //新增的角色只需要插入角色，新增关系表数据。
        sysRoleMapper.insertSelective(sysRole);
        LOGGER.info("----------------"+sysRole);
        sysRoleMenuMapper.batchInsert(roleMenuGroup);
    }
}
