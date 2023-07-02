package com.example.demo.dao.impl;

import com.example.demo.dao.RoleDao;
import com.example.demo.domain.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl extends BaseDaoImpl<RoleEntity> implements RoleDao {
    @Autowired
    private NativeQuery<RoleEntity> nativeQuery;

    @Override
    public List<RoleEntity> findByRoleName(String roleName) {
        String hql = "from RoleEntity where role_name like concat('%', :roleName, '%')";
        return nativeQuery.find(hql,"roleName", roleName, RoleEntity.class);
    }

    @Override
    public Long countByRoleName(String roleName) {
        String hql = "select count(*) from RoleEntity where role_name like :roleName";
        String n = "%" + roleName + "%";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("roleName",n);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public RoleEntity getByRoleName(String roleName) {
        String hql = "from RoleEntity where role_name=:roleName";
        return nativeQuery.get(hql,"roleName", roleName, RoleEntity.class);
    }
}
