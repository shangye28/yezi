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
        String hql = "select * from Role";
        return baseDao.find(hql);
    }

    @Override
    public List<Role> findByRoleName(String roleName) {
        String hql = "select * from Role where role_name=:roleName";
        Map<String,Object> m = new HashMap<>();
        m.put("roleName",roleName);
        return baseDao.find(hql,m);
    }

    @Override
    public List<Role> findByStatus(String status) {
        String hql = "select * from Role where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",status);
        return baseDao.find(hql,m);
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
