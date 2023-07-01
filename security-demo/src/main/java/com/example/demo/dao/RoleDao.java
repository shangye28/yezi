package com.example.demo.dao;



import com.example.demo.domain.RoleEntity;

import java.util.List;

public interface RoleDao extends BaseDao<RoleEntity>{
    public List<RoleEntity> findByRoleName(String roleName);

    public Long countByRoleName(String roleName);

    public RoleEntity getByRoleName(String roleName);
}
