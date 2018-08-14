package com.xinan.config.security;

import com.xinan.consts.SecurityConst;
import com.xinan.entity.User;
import com.xinan.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author XinAnzzZ
 * @date 2018/8/12 0012 13:14
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserInfoByUsername(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }
        // 认证的实体信息，可以使用用户名，也可以使用实体对象
        Object principal = user.getUsername();
        // 认证的证书，也就是认证的密码
        Object credentials = user.getPassword();
        String realmName = getName();
        // 盐
        ByteSource salt = ByteSource.Util.bytes(SecurityConst.SHIRO_SALT);
        return new SimpleAuthenticationInfo(principal, credentials, salt, realmName);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
