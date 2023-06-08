package com.example.demo.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    // 权限集合
    List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
    // 用户认证
    return new User("xgt",new BCryptPasswordEncoder().encode("123456"),authorities);
  }
}
