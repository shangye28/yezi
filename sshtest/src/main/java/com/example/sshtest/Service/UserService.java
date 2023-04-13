package com.example.sshtest.Service;


import com.example.sshtest.pojo.User;
import com.example.sshtest.utils.Pager;

import java.util.List;


public interface UserService{

    // 查询所有(支持分页)
    public Pager<User> findAll();
    //根据username查询(支持分页)
    public Pager<User> findByUsername(String username);
    //根据nickname查询(支持分页)
    public Pager<User> findByNickname(String nickname);

}