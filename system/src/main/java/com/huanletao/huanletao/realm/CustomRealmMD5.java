package com.huanletao.huanletao.realm;

import com.huanletao.huanletao.dto.ActiveUser;
import com.huanletao.huanletao.entity.SysMenu;
import com.huanletao.huanletao.entity.SysPermissions;
import com.huanletao.huanletao.entity.SysUser;
import com.huanletao.huanletao.mapper.SysMenuMapper;
import com.huanletao.huanletao.mapper.SysPermissionsMapper;
import com.huanletao.huanletao.mapper.SysUserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: 踏雪无痕。
 * @Date: 2019/12/14
 * @Time: 22:43
 * Description: 自定义realm 接口 支持散列算法，
 */
public class CustomRealmMD5 extends AuthorizingRealm {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysPermissionsMapper sysPermissionsMapper;

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

        SysUser user = sysUserMapper.findSysUserByUserCode(usercode);

        if (null == user){
            return null;
        }

        //设置相关属性。
        ActiveUser actviceUser = new ActiveUser(usercode,user.getPassword(),user.getMail());

        actviceUser.setRoleName(user.getRoleName());

        List<SysMenu> sysMenus = sysMenuMapper.findMenusByUser(user);
        List<SysPermissions> sysPermissions = sysPermissionsMapper.findPermissionByUser(user);

        actviceUser.setSysMenus(sysMenus);
        actviceUser.setSysPermissions(sysPermissions);
        String password = user.getPassword();

        //构造返回的认证信息实体，
        SimpleAuthenticationInfo authenticationInfo = new
                SimpleAuthenticationInfo(actviceUser,password,this.getName());

        return authenticationInfo;
    }

    @Override
    public void setName(String name) {
        super.setName("CustomRealmMD5");
    }
}
