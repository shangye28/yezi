package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository("RoleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
}
