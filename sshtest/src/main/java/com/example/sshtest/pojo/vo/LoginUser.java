//package com.example.sshtest.pojo.vo;
//
//import com.example.sshtest.pojo.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class LoginUser implements UserDetails {
//
//    private User user ;
//
//    private List<String> permission;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<String> getPermission() {
//        return permission;
//    }
//
//    public void setPermission(List<String> permission) {
//        this.permission = permission;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (String per : permission) {
//            authorities.add(new SimpleGrantedAuthority(per));
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {          // 账号是否没有过期
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {           // 账号是否没有被锁定
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {      // 账号的凭证是否没有过期
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {                    // 账号是否可用
//        return true;
//    }
//}
