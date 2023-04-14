//package com.example.sshtest.service.impl;
//
//import com.example.sshtest.service.RoleService;
//import com.example.sshtest.dao.RoleDao;
//import com.example.sshtest.pojo.Role;
//import com.example.sshtest.utils.Pager;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class RoleServiceImpl implements RoleService {
//
//    @Autowired
//    private RoleDao roleDao;
//
//    @Override
//    public Pager<Role> findAll() {
//        Pager<Role> p = new Pager<>();
//        p.setData(roleDao.findByAll());
//        p.setTotal(roleDao.countAll());
//        return p;
//    }
//
//    @Override
//    public Pager<Role> findByRoleName(String roleName) {
//        Pager<Role> p = new Pager<>();
//        p.setData(roleDao.findByRoleName(roleName));
//        p.setTotal(roleDao.countRoleName(roleName));
//        return p;
//    }
//
//    @Override
//    public Pager<Role> findByStatus(String status) {
//        Pager<Role> p = new Pager<>();
//        p.setData(roleDao.findByStatus(status));
//        p.setTotal(roleDao.countStatus(status));
//        return p;
//    }
//}
