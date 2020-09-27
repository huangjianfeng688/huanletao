package com.huanletao.huanletao.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/14
 * @Time: 22:43
 * Description: 自定义realm 接口。
 */
public class CustomRealm extends AuthorizingRealm {

    //用于授权的方法。
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用于认证的方法。
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名
        String  usercode = (String) authenticationToken.getPrincipal();

        //根据用户名，查询密码。
        //...
        //如果查询不到，返回null。

        //如果返回null 就会抛出未知账号异常， 如果密码不对，就抛出认证凭证异常。
        if (!usercode.equals("zhangsan")){
            return null;
        }
        //查询到的密码如下，
        String password = "123456";

        //构造返回的认证信息实体，
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(usercode,password,this.getName());

        return authenticationInfo;
    }

    @Override
    public void setName(String name) {
        super.setName("CustomRealm");
    }
}
