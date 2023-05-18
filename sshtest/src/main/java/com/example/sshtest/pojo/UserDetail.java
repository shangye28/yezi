package com.example.sshtest.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails {
    /**
     * 编号
     */
    private Integer userId;
    /**
     * 登陆名
     */
    private String username;
    /**
     * 密码
     */
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions;
    }
    /*封装权限集合*/
    private List<SimpleGrantedAuthority> permissions = new ArrayList<>();

    public List<SimpleGrantedAuthority> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SimpleGrantedAuthority> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
