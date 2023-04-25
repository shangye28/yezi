//package com.example.sshtest.security;
//
//import com.example.sshtest.dao.UserDao;
//import com.example.sshtest.pojo.Menu;
//import com.example.sshtest.pojo.Role;
//import com.example.sshtest.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyUserService implements UserDetailsService {
//    @Autowired
//    private UserDao userDao;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //1.根据登陆用户名称查询用户权限信
//        User user = userDao.getByUsername(username);
//        if(null != user){
//            //1.1 用户名存在：则获取对应密码
//            String password = user.getPassword();
//
//            //2 定义用户权限集合
//            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
//            SimpleGrantedAuthority authority = null;
//            //3 获取用户所拥有的角色
//            List<Role> roles =user.getRoles();
//            if(null != roles){
//                for (Role role : roles) {
//                    //3.1 授权角色：角色关键字授予角色,hasRole、hasAnyRole
//                    authority = new SimpleGrantedAuthority("ROLE_"+role.getRoleKey());
//                    authorityList.add(authority);
//                    //4 获取角色下的所有权限
//                    List<Menu> permissions = role.getMenus();
//                    if(null != permissions){
//                        for (Menu permission : permissions) {
//                            //4.1 授予权限：权限关键字授予权限,hasAuthority、hasAnyAuthority
//                            authority = new SimpleGrantedAuthority(permission.getPermission());
//                            authorityList.add(authority);
//                        }
//                    }
//                }
//            }
//            //5 返回security需要的Userdetails登录信息，会保存到session
//            return new org.springframework.security.core.userdetails.User(username,password,authorityList);
//        }
//        //6.没有该用户返回null, 限制访问
//        return null;
//    }
//}
