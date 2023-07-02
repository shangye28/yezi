package com.example.demo.service.impl;

import com.example.demo.dao.BaseDao;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void delete(T o) {
        baseDao.delete(o);
    }

    @Override
    @Transactional
    public void save(T o) {
        baseDao.save(o);
    }

    @Override
    @Transactional
    public void update(T o) {
        baseDao.update(o);
    }


}
