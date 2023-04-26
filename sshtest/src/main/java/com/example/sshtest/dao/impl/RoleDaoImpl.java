package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    @Autowired
    private NativeQuery<Role> nativeQuery;
    @Override
    public List<Role> findByRoleName(String roleName) {
        String hql = "from Role where role_name like concat('%', :roleName, '%')";
        return nativeQuery.find(hql,"roleName", roleName, Role.class);
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
        String hql = "from Role where role_name=:roleName";
        return nativeQuery.get(hql,"roleName", roleName, Role.class);
    }
}
