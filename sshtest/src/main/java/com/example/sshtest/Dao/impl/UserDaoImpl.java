package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    private BaseDao<User> baseDao;

    public BaseDao<User> getBaseDao() {
        return baseDao;
    }
    @Autowired
    public void setBaseDao(BaseDao<User> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public List<User> findByAll() {
        String hql = "select * from User";
        return baseDao.find(hql);
    }

    @Override
    public List<User> findByUsername(String username) {
        String hql = "select * from User where username like '%:username%'";
        Map<String,Object> m = new HashMap<>();
        m.put("username",username);
        return baseDao.find(hql,m);
    }

    @Override
    public List<User> findByNickname(String nickname) {
        String hql = "select * from User where nickname like '%:nickname%'";
        Map<String,Object> m = new HashMap<>();
        m.put("nickname",nickname);
        return baseDao.find(hql,m);
    }

    @Override
    public User getByUsername(String username){
        String hql = "select * from User where username=:username";
        Map<String,Object> m = new HashMap<>();
        m.put("username",username);
        return baseDao.get(hql,m);
    }

    @Override
    public void delete(User user) {
        baseDao.delete(user);
    }

    @Override
    public void save(User user) {
        baseDao.save(user);
    }

    @Override
    public void updata(User user){
        baseDao.update(user);
    }
}
