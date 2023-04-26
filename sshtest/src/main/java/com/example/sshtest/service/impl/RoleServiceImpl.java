package com.example.sshtest.service.impl;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.RoleService;
import com.example.sshtest.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public PageVO<Role> findByRoleName(String roleName) {
        PageVO<Role> p = new PageVO<>();
        p.setList(roleDao.findByRoleName(roleName));
        p.setTotal(roleDao.countByRoleName(roleName));
        return p;
    }

    @Override
    public boolean checkRoleNameUnique(String roleName) {
        if(roleDao.getByRoleName(roleName) == null)
            return true;
        else
            return false;
    }
}
