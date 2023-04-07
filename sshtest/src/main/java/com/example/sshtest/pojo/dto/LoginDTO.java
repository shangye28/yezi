package com.example.sshtest.pojo.dto;

import com.example.sshtest.pojo.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDTO implements Serializable {
    private String username;
    //    @JsonIgnore
    private String password;
    private String userToken;
//    private List<Menu> menus;
//    private String rolename;
//    private String RULpath;
}