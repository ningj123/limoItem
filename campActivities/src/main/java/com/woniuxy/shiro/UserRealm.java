package com.woniuxy.shiro;

import com.woniuxy.doman.LimoManage;
import com.woniuxy.doman.LimoMenu;
import com.woniuxy.service.LimoManageService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;


import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    public LimoManageService manageService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LimoManage manage = (LimoManage) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<LimoMenu> permissions = manageService.selectManagePermissions(manage);
            for (LimoMenu permission : permissions) {
                simpleAuthorizationInfo.addStringPermission(permission.getmName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    //登陆
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //取出令牌中的用户名
        String phone = (String) token.getPrincipal();
        SimpleAuthenticationInfo authenticationInfo = null;
        try {
            LimoManage manage = manageService.manageLogin(phone);
            if (manage != null) {
                //封装认证信息
                //shiro会使用这个对象进行后续的密码比对
                SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(manage, manage.getmPassword(), getName());
                return simpleAuthenticationInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
