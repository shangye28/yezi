//package com.example.sshtest.service.impl;
//
//import com.example.sshtest.pojo.Role;
//import com.example.sshtest.pojo.User;
//import com.example.sshtest.service.UserService;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//    @Resource
//    private UserService userService;
//    @Resource
//    private PasswordEncoder passwordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        /**
//         * 1/通过userName 获取到userInfo信息
//         * 2/通过User（UserDetails）返回details。
//         */
//        //通过userName获取用户信息
//        User user = userService.getByUsername(userName);
//        if(user == null) {
//            throw new UsernameNotFoundException("not found");
//        }
//        //定义权限列表.
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        List<Role> list = user.getRoles();
//        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
//        authorities.add(new SimpleGrantedAuthority("ROLE_"+ list.get(0).getRoleKey()));
//        User userDetails = new User(user.getUsername(),passwordEncoder.encode(user.getPassword()),authorities);
//        return userDetails;
//    }
//}
