package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.User;
import com.example.sshtest.utils.CRUDUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    @Override
    public List<Role> findByRoleName(String roleName) {
        CRUDUtils<Role> crudUtils = new CRUDUtils<>();
        String hql = "from Role where role_name like :roleName";
        String n = "%" + roleName + "%";
        Query query = this.entityManager.createQuery(hql,Role.class);
        return crudUtils.find(query, "roleName", n);
    }

    @Override
    public Long countByRoleName(String roleName) {
        String hql = "select count(*) from Role where role_name like :roleName";
        String n = "%" + roleName + "%";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("roleName",n);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Role getByRoleName(String roleName) {
        CRUDUtils<Role> crudUtils = new CRUDUtils<>();
        String hql = "from Role where role_name=:roleName";
        Query q = this.entityManager.createQuery(hql,Role.class);
        return crudUtils.get(q, "roleName", roleName);
    }
}
