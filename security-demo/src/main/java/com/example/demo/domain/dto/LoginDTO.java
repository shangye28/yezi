package com.example.demo.domain.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private String username;

    private String password;

    private String userToken;
//    private List<Menu> menus;
//    private String rolename;
//    private String RULpath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

}