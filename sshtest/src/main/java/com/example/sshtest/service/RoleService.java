package com.example.sshtest.service;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.vo.PageVO;


public interface RoleService extends BaseService<Role> {
    public PageVO<Role> findByRoleName(String roleName);

    public boolean delete(Integer roleId);
    public boolean save(Role role);
    public boolean update(Role Role);

    public boolean checkRoleNameUnique(String roleName);
}
