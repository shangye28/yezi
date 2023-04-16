package com.example.sshtest.service;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.dto.PageDTO;


public interface RoleService {
    public PageDTO<Role> findAll();
}
