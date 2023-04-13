package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository("RoleDao")
public class RoleDaoImpl implements RoleDao {

    private BaseDao<Role> baseDao;

    public BaseDao<Role> getBaseDao() {
        return baseDao;
    }
    @Autowired
    public void setBaseDao(BaseDao<Role> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public List<Role> findByAll() {
        String hql = "from Role";
        return baseDao.find(hql, Role.class);
    }

    @Override
    public List<Role> findByRoleName(String roleName) {
        String hql = "from Role where role_name like :roleName";
        String n = "%" + roleName + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("roleName",n);
        return baseDao.find(hql, m, Role.class);
    }

    @Override
    public List<Role> findByStatus(String status) {
        String hql = "from Role where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",status);
        return baseDao.find(hql, m, Role.class);
    }
    @Override
    public Long countAll(){
        String hql = "select count(*) from Role";
        return baseDao.count(hql);
    }
    @Override
    public Long countRoleName(String str){
        String hql = "select count(*) from Role where role_name like :roleName";
        String n = "%" + str + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("roleName",n);
        return baseDao.count(hql, m);
    }

    @Override
    public Long countStatus(String str){
        String hql = "select count(*) from Role where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",str);
        return baseDao.count(hql, m);
    }

    @Override
    public void delete(Role role) {
        baseDao.delete(role);
    }

    @Override
    public void save(Role role) {
        baseDao.save(role);
    }

    @Override
    public void updata(Role role){
        baseDao.update(role);
    }

}
