package com.example.sshtest.dao;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.User;

import java.util.List;

public interface RoleDao extends BaseDao<Role>{
    public List<Role> findByRoleName(String roleName);

    public Long countByRoleName(String roleName);

    public Role getByRoleName(String roleName);
}
