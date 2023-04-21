package com.example.sshtest.service.impl;

import com.example.sshtest.dao.BaseDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;
    @Override
    public PageVO<T> findAll() {
        PageVO<T> p = new PageVO<>();
        p.setList(baseDao.find());
        p.setTotal(baseDao.count());
        return p;
    }
}
