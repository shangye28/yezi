package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.*;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Autowired
    private NativeQuery<User> nativeQuery;
    @Override
    public List<User> findByUsername(String username) {
        String hql = "from User where username like concat('%', :username, '%')";
        return nativeQuery.find(hql,"username", username, User.class);
    }

    @Override
    public List<User> findByNickname(String nickname) {
        String hql = "from User where nickname like concat('%', :nickname, '%')";
        return nativeQuery.find(hql,"nickname", nickname, User.class);
    }

    @Override
    public List<User> findByDeptName(String deptName) {
        String hql = "from User left join Dept on User.dept_id=Dept.dept_id where Dept.dept_name=:deptName";
        return nativeQuery.find(hql,"deptName", deptName, User.class);
    }

    @Override
    public Long countByUsername(String username) {
        String hql = "select count(*) from User where username like concat('%', :username, '%')";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("username",username);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Long countByNickname(String nickname) {
        String hql = "select count(*) from User where nickname like concat('%', :nickname, '%')";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("nickname",nickname);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Long countByDeptName(String deptName) {
        String hql = "select count(*) from user left join dept on user.deptId=dept.deptId where dept.deptName=:deptName";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("deptName",deptName);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public User getByUsername(String username) {
        String hql = "from User where username=:username";
        return nativeQuery.get(hql,"username", username, User.class);
    }


//    private BaseDao<User> baseDao;
//
//    public BaseDao<User> getBaseDao() {
//        return baseDao;
//    }
//    @Autowired
//    public void setBaseDao(BaseDao<User> baseDao) {
//        this.baseDao = baseDao;
//    }
//
//    @Override
//    public List<User> findByAll() {
//        String hql = "from User";
//        return baseDao.find(hql, User.class);
//    }
//
//    @Override
//    public List<User> findByUsername(String username) {
//        String hql = "from User where username like :username";
//        String n = "%" + username + "%";
//        Map<String,Object> m = new HashMap<>();
//        m.put("username",n);
//        return baseDao.find(hql, m, User.class);
//    }
//
//    @Override
//    public List<User> findByNickname(String nickname) {
//        String hql = "from User where nickname like :nickname";
//        String n = "%" + nickname + "%";
//        Map<String,Object> m = new HashMap<>();
//        m.put("nickname",n);
//        return baseDao.find(hql, m, User.class);
//    }
//
//    @Override
//    public User getByUsername(String username){
//        String hql = "from User where username=:username";
//        Map<String,Object> m = new HashMap<>();
//        m.put("username",username);
//        return baseDao.get(hql, m, User.class);
//    }
//
//    @Override
//    public User getByUserId(Integer id){
//        String hql = "from User where user_id=:userId";
//        Map<String,Object> m = new HashMap<>();
//        m.put("userId",id);
//        return baseDao.get(hql, m, User.class);
//    }
//
//
//    @Override
//    public User getByEmail(String email){
//        String hql = "from User where email=:email";
//        Map<String,Object> m = new HashMap<>();
//        m.put("email",email);
//        return baseDao.get(hql, m, User.class);
//    }
//
//    @Override
//    public User getByPhone(String phone){
//        String hql = "from User where phone=:phone";
//        Map<String,Object> m = new HashMap<>();
//        m.put("phone",phone);
//        return baseDao.get(hql, m, User.class);
//    }
//
//
//    @Override
//    public Long countAll(){
//        String hql = "select count(*) from User";
//        return baseDao.count(hql);
//    }
//
//    @Override
//    public Long countUsername(String str){
//        String hql = "select count(*) from User where username like :username";
//        String n = "%" + str + "%";
//        Map<String,Object> m = new HashMap<>();
//        m.put("username",n);
//        return baseDao.count(hql, m);
//    }
//
//    @Override
//    public Long countNickname(String str){
//        String hql = "select count(*) from User where nickname like :nickname";
//        String n = "%" + str + "%";
//        Map<String,Object> m = new HashMap<>();
//        m.put("nickname",n);
//        return baseDao.count(hql, m);
//    }
//
//    @Override
//    public void delete(User user) {
//        baseDao.delete(user);
//    }
//
//    @Override
//    public void save(User user) {
//        baseDao.save(user);
//    }
//
//    @Override
//    public void updata(User user){
//        baseDao.update(user);
//    }
}
