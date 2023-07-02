package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageVO<UserEntity> findByName(String username, String nickname) {
        PageVO<UserEntity> p = new PageVO<>();
        if(username != null){
            p.setList(userDao.findByUsername(username));
            p.setTotal(userDao.countByUsername(username));
        }else{
            p.setList(userDao.findByNickname(nickname));
            p.setTotal(userDao.countByNickname(nickname));
        }
        return p;
    }

    @Override
    public PageVO<UserEntity> findByDeptName(String deptName) {
        PageVO<UserEntity> p = new PageVO<>();
        p.setList(userDao.findByDeptName(deptName));
        p.setTotal(userDao.countByDeptName(deptName));
        return p;
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public boolean checkUsernameUnique(String username) {
        if(userDao.getByUsername(username) == null)
            return true;
        else
            return false;
    }
}