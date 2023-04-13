package com.example.sshtest.dao;

import com.example.sshtest.pojo.Role;
import java.util.List;


public interface RoleDao {
    public List<Role> findByAll();
    public List<Role> findByRoleName(String roleName);
    public List<Role> findByStatus(String status);
    public Long countAll();
    public Long countRoleName(String str);
    public Long countStatus(String str);
    public void delete(Role role);
    public void save(Role role);
    public void updata(Role role);
}
