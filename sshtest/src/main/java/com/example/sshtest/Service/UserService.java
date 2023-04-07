package com.example.sshtest.Service;


import com.example.sshtest.pojo.User;


public interface UserService{

    // 查询所有
    public Iterable<User> findAll();
    //根据username查询
    public User findByUsername(String username);
    //根据nickname查询
    public User findByNickname(String nickname);
    //根据Id删除
    public void deleteById(Integer id);



}