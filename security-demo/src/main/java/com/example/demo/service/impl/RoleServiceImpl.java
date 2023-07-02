package com.example.demo.service.impl;

import com.example.demo.dao.RoleDao;
import com.example.demo.domain.RoleEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleEntity> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public PageVO<RoleEntity> findByRoleName(String roleName) {
        PageVO<RoleEntity> p = new PageVO<>();
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