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
 * @ClassName ManagerRealm
 * @Author shadow
 * @Date 2020/11/12 9:54
 * @Description TODO
 **/
public class ManagerRealm extends AuthorizingRealm {
    @Resource
    private LimoManageService limoManageService;
    @Resource
    private LimoMenuService limoMenuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        LimoManage employee=(LimoManage)principals.getPrimaryPrincipal();
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        try {
//            List<LimoMenu> permissions = LimoMenuService.selectPermission(employee);
//            for (LimoMenu LimoMenu : permissions) {
//                simpleAuthorizationInfo.addStringPermission(LimoMenu.getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        String phone=(String)token.getPrincipal();
//        SimpleAuthenticationInfo authenticationInfo=null;
//        try {
//            LimoManage LimoManage=(LimoManage) LimoManageService.selectByPhone(phone);
//            authenticationInfo = new SimpleAuthenticationInfo(LimoManage,LimoManage.getPassword(),getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
