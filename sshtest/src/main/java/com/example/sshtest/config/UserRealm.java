//package com.example.sshtest.config;
//
//
//import com.example.sshtest.pojo.User;
//import com.example.sshtest.service.UserService;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class UserRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;
//
//
//
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.err.println("执行了+==========>认证AuthenticationInfo");
//        // 用户名密码数据库里取
//        UsernamePasswordToken userToken =(UsernamePasswordToken) token;
//        User queryUser = new User();
//        queryUser.setUsername(userToken.getUsername());
//
//        List<User> userList = userService.(queryUser);
//
//
//        if(CollectionUtils.isEmpty(userList)){
//            return null;
//        }else {
//            IUser user = userList.get(0);
//            System.err.println("user:"+user);
//
//            // 密码认证 简单的equals比较
//            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(),"");
//        }
//
//    }
//
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.err.println("执行了+==========>授权doGetAuthenticationInfo");
//        String username = (String)principals.getPrimaryPrincipal();
//        System.err.println("username"+username);
//        IUser queryUser = new IUser();
//        queryUser.setUserName(username);
////        根据用户名获取身份、再由身份获取权限
//        List<IRole> roles = userService.selectRolesByUser(queryUser);
//        if(CollectionUtils.isEmpty(roles)){
//            return null;
//        }else {
//            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//            roles.forEach(role -> {
//                simpleAuthorizationInfo.addRole(role.getName());
//                //权限信息
//                List<IPermission> perms = userService.selectPermsByRole(role);
//                if (!CollectionUtils.isEmpty(perms)) {
//                    perms.forEach(permission -> {
//                        simpleAuthorizationInfo.addStringPermission(permission.getPermission());
//                    });
//                }
//            });
//            return simpleAuthorizationInfo;
//        }
//    }
//
//}
