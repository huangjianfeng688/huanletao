package com.huanletao.huanletao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huanletao.huanletao.entity.WebUser;
import com.huanletao.huanletao.entity.WebUserExample;
import com.huanletao.huanletao.mapper.WebUserMapper;
import com.huanletao.huanletao.service.api.UserServices;
import com.huanletao.huanletao.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 16:32
 * Description:
 */@Service
public class UserServiceimpl implements UserServices {
     @Autowired
     private WebUserMapper webUserMapper;

     //带分页功能的查询
    @Override
    public List<WebUser> findAll() {
        WebUserExample example = new WebUserExample();
        WebUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsertypeEqualTo(1);

        return webUserMapper.selectByExample(example);
    }

    //删除用户信息，
    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            webUserMapper.deleteByPrimaryKey(id);
        }
    }

    //搜锁用户
    @Override
    public List<WebUser> search(String keyword) {
        System.out.println("keyword = " + keyword);
        PageHelper.startPage(1,10);
        WebUserExample example = new WebUserExample();
        WebUserExample.Criteria criteria = example.createCriteria();
        criteria.andCollegeLike("%"+keyword+"%");
        List<WebUser> webUsers = webUserMapper.selectByExample(example);

        Page<WebUser> webUserPage = (Page<WebUser>) webUsers;

        return  null;
    }

    //保存用户注册信息
    @Override
    public void save(WebUser user) {
        user.setUsertype(1);
        //对密码进加密。
        String password = MD5Utils.MD5Encode(user.getPassword());
        user.setPassword(password);
        //最后保存数据库。
        webUserMapper.insert(user);
    }

    //查询一个用户信息。
    @Override
    public WebUser findOneByUserCode(String userCode) {
        return webUserMapper.findOneByUserCode(userCode);
    }

    //更新一个用户信息
    @Override
    public void updateUser(WebUser user) {
        webUserMapper.updateByPrimaryKey(user);
    }

    //管理员登录。
    @Override
    public WebUser adminLogin(String username, String password) {
        String encode = MD5Utils.MD5Encode(password);
        WebUser admin = webUserMapper.findAdmin(username);
        if (admin!= null){
            if (admin.getPassword().equals(encode)){
                return admin;
            }
        }
        return null;
    }

    //用户登录。
    @Override
    public WebUser userLogin(String username, String password) {
        String md5pwd = MD5Utils.MD5Encode(password);
        WebUser oneByUserCode = webUserMapper.findOneByUserCode(username);
        if (oneByUserCode!=null){
            if (oneByUserCode.getPassword().equals(md5pwd)){
                return oneByUserCode;
            }
        }
        return null;
    }


    @Override
    public WebUser findByGoodId(int goodid) {
        return webUserMapper.findByGoodId(goodid);
    }
}
