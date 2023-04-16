package com.example.sshtest.service.impl;

import com.example.sshtest.pojo.dto.PageDTO;
import com.example.sshtest.service.RoleService;
import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public PageDTO<Role> findAll() {
        PageDTO<Role> p = new PageDTO<>();
        p.setList(roleDao.find());
        p.setTotal(roleDao.count());
        return p;
    }
}
