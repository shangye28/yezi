package com.example.demo.services;


import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    // 权限集合
//    List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
//    // 用户认证
//    return new User1("xgt",new BCryptPasswordEncoder().encode("123456"),authorities);
    /*通过账号查询用户*/
    UserEntity user = userDao.getByUsername(username);
    /*根据用户的id 获取用户的 权限字符串 集合*/
    List<String> permissions = userDao.getPermissionByUsername(user.getUsername());
    System.out.println(user.getUsername());
    if (user == null) {
      throw new UsernameNotFoundException("用户名不存在");
    }
    UserDetails userDetails = User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .roles("ADMIN","USER")
            .build();
    return userDetails;
  }
}