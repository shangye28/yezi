//package com.example.sshtest.service.impl;
//
//import com.example.sshtest.dao.UserDao;
//import com.example.sshtest.pojo.User;
//import com.example.sshtest.pojo.vo.LoginUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //根据用户名查询用户信息
//        User user = userDao.getByUsername(username);
//        //判断是否查到用户  如果没查到抛出异常
//        if(Objects.isNull(user)){
//            throw new RuntimeException("用户不存在");
//        }
//        List<String> list = new ArrayList<>();
//        list.add("ROLE_admin");
//        LoginUser loginUser = new LoginUser();
//        loginUser.setUser(user);
//        loginUser.setPermission(list);
//        //返回用户信息
//        // TODO 查询权限信息封装
//        return loginUser;
//    }
//}
