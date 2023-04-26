package com.example.sshtest.service;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.vo.PageVO;


public interface RoleService extends BaseService<Role> {
    public PageVO<Role> findByRoleName(String roleName);

    public boolean checkRoleNameUnique(String roleName);
}
