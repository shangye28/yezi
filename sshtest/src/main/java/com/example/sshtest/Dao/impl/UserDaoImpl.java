package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import com.example.sshtest.dao.UserDao;
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
        String hql = "from User";
        return baseDao.find(hql, User.class);
    }

    @Override
    public List<User> findByUsername(String username) {
        String hql = "from User where username like :username";
        String n = "%" + username + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("username",n);
        return baseDao.find(hql, m, User.class);
    }

    @Override
    public List<User> findByNickname(String nickname) {
        String hql = "from User where nickname like :nickname";
        String n = "%" + nickname + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("nickname",n);
        return baseDao.find(hql, m, User.class);
    }

    @Override
    public User getByUsername(String username){
        String hql = "from User where username=:username";
        Map<String,Object> m = new HashMap<>();
        m.put("username",username);
        return baseDao.get(hql, m, User.class);
    }

    @Override
    public Long countAll(){
        String hql = "select count(*) from User";
        return baseDao.count(hql);
    }

    @Override
    public Long countUsername(String str){
        String hql = "select count(*) from User where username like :username";
        String n = "%" + str + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("username",n);
        return baseDao.count(hql, m);
    }

    @Override
    public Long countNickname(String str){
        String hql = "select count(*) from User where nickname like :nickname";
        String n = "%" + str + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("nickname",n);
        return baseDao.count(hql, m);
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
