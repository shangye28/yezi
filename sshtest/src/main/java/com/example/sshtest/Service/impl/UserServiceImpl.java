package com.example.sshtest.Service.impl;


import com.example.sshtest.Service.UserService;
import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Pager<User> findAll() {
        Pager<User> p = new Pager<>();
        p.setData(userDao.findByAll());
        p.setTotal(userDao.countAll());
        return p;
    }

    @Override
    public Pager<User> findByUsername(String username) {
        Pager<User> p = new Pager<>();
        p.setData(userDao.findByUsername(username));
        p.setTotal(userDao.countUsername(username));
        return p;
    }

    @Override
    public Pager<User> findByNickname(String nickname) {
        Pager<User> p = new Pager<>();
        p.setData(userDao.findByNickname(nickname));
        p.setTotal(userDao.countNickname(nickname));
        return p;
    }
}
