package com.example.sshtest.service.impl;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.RoleService;
import com.example.sshtest.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public PageVO<Role> findAll() {
        PageVO<Role> p = new PageVO<>();
        p.setList(roleDao.find());
        p.setTotal(roleDao.count());
        return p;
    }
}
