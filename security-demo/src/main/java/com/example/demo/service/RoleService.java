package com.example.demo.service;

import com.example.demo.domain.RoleEntity;
import com.example.demo.domain.vo.PageVO;

public interface RoleService extends BaseService<RoleEntity> {
    public PageVO<RoleEntity> findByRoleName(String roleName);

    public boolean checkRoleNameUnique(String roleName);
}
