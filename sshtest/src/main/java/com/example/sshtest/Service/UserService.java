package com.example.sshtest.Service;


import com.example.sshtest.pojo.User;

import java.util.List;


public interface UserService{

    // 查询所有
    public List<User> findAll();
    //根据username查询
    public User findByUsername(String username);
    //根据nickname查询
    public User findByNickname(String nickname);

}