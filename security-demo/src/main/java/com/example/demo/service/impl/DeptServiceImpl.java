package com.example.demo.service.impl;

import com.example.demo.dao.DeptDao;
import com.example.demo.domain.DeptEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptEntity> implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public PageVO<DeptEntity> findByDeptName(String deptName) {
        PageVO<DeptEntity> p = new PageVO<>();
        p.setList(deptDao.findByDeptName(deptName));
        p.setTotal(deptDao.countByDeptName(deptName));
        return p;
    }

    @Override
    public List<DeptEntity> treeList() {
        return deptDao.treeList();
    }

    @Override
    public boolean checkDeptNameUnique(String deptName) {
        return false;
    }
}