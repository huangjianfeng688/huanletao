package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.MenuOptionVO;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.SysMenu;
import com.huanletao.huanletao.service.api.MeunSevice;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2020/9/27
 * @Time: 22:03
 * Description: 菜单控制器。
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Resource
    private MeunSevice meunSevice;

    @GetMapping("findAll")
    public ResponseObject findAllMenu(){
        List<SysMenu> sysMenuList = meunSevice.findAllMenu();
        return ResponseObject.success(ResponseEnum.SELECTSUCCESS).setData(sysMenuList);
    }

    @PostMapping("add")
    public ResponseObject addSysMenu(@RequestBody SysMenu sysMenu){
        meunSevice.addSysMenu(sysMenu);
        return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }

    @PutMapping("update")
    public ResponseObject updateSysMenu(@RequestBody SysMenu sysMenu){
        meunSevice.updateSysMenu(sysMenu);
        return ResponseObject.success(ResponseEnum.UPDATESUCCESS);
    }

    @GetMapping("find/{id}")
    public ResponseObject findOne(@PathVariable Integer id){
        SysMenu sysMenu = meunSevice.findOne(id);
        return ResponseObject.success(ResponseEnum.SELECTSUCCESS).setData(sysMenu);
    }

    @GetMapping("listMenus")
    public ResponseObject ListMeuns(String keyWord){
        List<MenuOptionVO> sysMenuList = meunSevice.listMenuOption(keyWord);
        return ResponseObject.success(ResponseEnum.SELECTSUCCESS).setData(sysMenuList);
    }


}
