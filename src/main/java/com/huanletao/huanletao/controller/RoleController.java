package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.dto.RoleMenuGroupDTO;
import com.huanletao.huanletao.entity.SysRole;
import com.huanletao.huanletao.service.api.RoleService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/9/27
 * @Time: 22:02
 * Description:角色管理控制器。
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Resource
    private RoleService roleService;

    private static final Logger logger = Logger.getLogger(RoleController.class);

    @GetMapping("findAll")
    public ResponseObject findAllRole(){
        List<SysRole> roles = roleService.findAll();
        logger.info("查询结果为：=="+roles);
        return ResponseObject.success(ResponseEnum.SELECTSUCCESS).setData(roles);
    }

    @PostMapping("add")
    public ResponseObject addSysRole(@RequestBody SysRole sysRole){
        roleService.addSysRole(sysRole);
        return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }

    @PutMapping("update")
    public ResponseObject updateSysRole(@RequestBody SysRole sysRole){
        roleService.updateSysRole(sysRole);
        return ResponseObject.success(ResponseEnum.UPDATESUCCESS);
    }

    @GetMapping("find/{id}")
    public ResponseObject findOne(@PathVariable Integer id){
       SysRole sysRole = roleService.findOne(id);
       return ResponseObject.success(ResponseEnum.SELECTSUCCESS).setData(sysRole);
    }

    @PostMapping("save")
    public ResponseObject saveRoleMenus(@RequestBody RoleMenuGroupDTO roleMenuGroup){


        System.out.println("roleMenuGroup = " + roleMenuGroup);

        SysRole sysRole = roleMenuGroup.getSysRole();
        System.out.println("sysRole = " + sysRole);

        roleService.updateSysRoleMenus(roleMenuGroup);

        return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }
}
