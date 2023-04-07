package com.example.sshtest.Service.impl;

import com.example.sshtest.Dao.UserDao;
import com.example.sshtest.Service.UserService;
import com.example.sshtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
// 在类上声明，开启所有public权限方法的事务处理
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByNickname(String nickname) {
        return userDao.findByNickname(nickname);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

}
