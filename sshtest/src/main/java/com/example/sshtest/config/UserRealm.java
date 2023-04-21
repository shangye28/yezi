package com.example.sshtest.config;


import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.User;
import com.example.sshtest.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("执行了+==========>认证AuthenticationInfo");
        // 用户名密码数据库里取
        UsernamePasswordToken userToken =(UsernamePasswordToken) token;
        User queryUser = new User();
        queryUser.setUsername(userToken.getUsername());

        List<User> userList = userDao.findByUsername(queryUser.getUsername());


        if(CollectionUtils.isEmpty(userList)){
            return null;
        }else {
            User user = userList.get(0);
            System.err.println("user:"+user);

            // 密码认证 简单的equals比较
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),"");
        }

    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.err.println("执行了+==========>授权doGetAuthenticationInfo");
        String username = (String)principals.getPrimaryPrincipal();
        System.err.println("username"+username);
        User queryUser = new User();
        queryUser.setUsername(username);
//        根据用户名获取身份、再由身份获取权限
        List<Role> roles = userDao.getByUsername(queryUser.getUsername()).getRoles();
        if(CollectionUtils.isEmpty(roles)){
            return null;
        }else {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            roles.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getRoleName());
                //权限信息
                List<Menu> perms = role.getMenus();
                if (!CollectionUtils.isEmpty(perms)) {
                    perms.forEach(permission -> {
                        simpleAuthorizationInfo.addStringPermission(permission.getPermission());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
    }

}
