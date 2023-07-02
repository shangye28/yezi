package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {
    @Autowired
    private NativeQuery<UserEntity> nativeQuery;

    @Override
    public List<UserEntity> findByUsername(String username) {
        String hql = "from UserEntity where username like concat('%', :username, '%')";
        return nativeQuery.find(hql,"username", username, UserEntity.class);
    }

    @Override
    public List<UserEntity> findByNickname(String nickname) {
        String hql = "from UserEntity where nickname like concat('%', :nickname, '%')";
        return nativeQuery.find(hql,"nickname", nickname, UserEntity.class);
    }

    @Override
    public List<UserEntity> findByDeptName(String deptName) {
        String hql = "from UserEntity left join DeptEntity on UserEntity.dept_id=DeptEntity.dept_id where DeptEntity.dept_name=:deptName";
        return nativeQuery.find(hql,"deptName", deptName, UserEntity.class);
    }

    @Override
    public List<String> getPermissionByUsername(String username) {
        String hql = "SELECT permission FROM MenuEntity LEFT JOIN role_menu  ON menu.menu_id = role_menu.menu_id WHERE role_id IN \n" +
                "(SELECT role_id FROM UserEntity LEFT JOIN  user_role ON user.user_id = user_role.user_id WHERE username = :username)";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("username",username);
        List<String> list = q.getResultList();
        return list;
    }

    @Override
    public Long countByUsername(String username) {
        String hql = "select count(*) from UserEntity where username like concat('%', :username, '%')";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("username",username);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Long countByNickname(String nickname) {
        String hql = "select count(*) from UserEntity where nickname like concat('%', :nickname, '%')";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("nickname",nickname);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Long countByDeptName(String deptName) {
        String hql = "select count(*) from UserEntity left join DeptEntity on user.deptId=dept.deptId where dept.deptName=:deptName";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("deptName",deptName);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public UserEntity getByUsername(String username) {
        String hql = "from UserEntity where username=:username";
        return nativeQuery.get(hql,"username", username, UserEntity.class);
    }
}