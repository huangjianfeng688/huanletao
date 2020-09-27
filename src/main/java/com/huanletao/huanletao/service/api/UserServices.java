package com.huanletao.huanletao.service.api;

import com.huanletao.huanletao.entity.WebUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/21
 * @Time: 16:31
 * Description:
 */
public interface UserServices {

    //查询所有用户数据信息
    List<WebUser> findAll();

    //删除用户信息，
    void delete(int[] ids);

    //搜索用户信息
    List<WebUser> search(String keyword);

    //保存用户注册信息。
    void save(WebUser user);

    //查询一个用户信息。
    WebUser findOneByUserCode(String userCode);

    //更新用户信息。
    void updateUser(WebUser user);

    //管理员登录。
    WebUser adminLogin(String username, String password);

    //用户登录。
    WebUser userLogin(String username, String password);

    //根据商品编号查询用户
    WebUser findByGoodId(int goodid);
}
