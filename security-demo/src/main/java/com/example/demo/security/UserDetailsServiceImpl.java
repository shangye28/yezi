package com.example.demo.security;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.MenuEntity;
import com.example.demo.domain.RoleEntity;
import com.example.demo.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userDao.getByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("用户名不存在");
    }
    List<GrantedAuthority> authorities = new ArrayList<>();
    List<RoleEntity> roles = user.getRoleEntities();
    for (RoleEntity role : roles) {
      authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleKey()));
      List<MenuEntity> permissions = role.getMenuEntities();
      for (MenuEntity permission : permissions) {
        authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
      }
    }
    UserDetails userDetails = User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .authorities(authorities)
            .build();
    return userDetails;
  }
}