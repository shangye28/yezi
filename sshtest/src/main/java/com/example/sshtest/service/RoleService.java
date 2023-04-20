package com.example.sshtest.service;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.vo.PageVO;


public interface RoleService {
    public PageVO<Role> findAll();
}
