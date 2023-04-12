package com.example.sshtest.Service.impl;


import com.example.sshtest.Service.UserService;
import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//// 在类上声明，开启所有public权限方法的事务处理
//@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDao roleDao;
    @Override
    public List<User> findAll() {
        List<User> user = userDao.findByAll();
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByNickname(String nickname) {
        return null;
    }
}
