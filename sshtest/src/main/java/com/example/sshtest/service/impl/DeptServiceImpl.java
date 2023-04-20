package com.example.sshtest.service.impl;

import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public PageVO<Dept> findAll() {
        PageVO<Dept> p = new PageVO<>();
        p.setList(deptDao.find());
        p.setTotal(deptDao.count());
        return p;
    }
}
