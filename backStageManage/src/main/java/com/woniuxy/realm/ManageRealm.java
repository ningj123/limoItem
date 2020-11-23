package com.woniuxy.realm;

import com.woniuxy.domain.LimoManage;
import com.woniuxy.domain.LimoMenu;
import com.woniuxy.service.LimoManageService;
import com.woniuxy.service.LimoMenuService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ManageRealm
 * @Author shadow
 * @Date 2020/11/12 15:59
 * @Description TODO
 **/
public class ManageRealm extends AuthorizingRealm {
    @Resource
    private LimoManageService limoManageService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LimoManage limoManage=(LimoManage)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<LimoMenu> permissions = limoManageService.selectManagePermissions(limoManage);
            for (LimoMenu menu : permissions) {
                simpleAuthorizationInfo.addStringPermission(menu.getmName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phone=(String)token.getPrincipal();
        SimpleAuthenticationInfo authenticationInfo=null;
        try {
            LimoManage limoManage=(LimoManage) limoManageService.manageLogin(phone);
            authenticationInfo = new SimpleAuthenticationInfo(limoManage,limoManage.getmPassword(),getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationInfo;
    }
}
