package com.example.sshtest.dao;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleDao {
    public List<Role> findByAll();
    public List<Role> findByRoleName(String roleName);
    public List<Role> findByStatus(String status);
    public void delete(Role role);
    public void save(Role role);
    public void updata(Role role);
}
