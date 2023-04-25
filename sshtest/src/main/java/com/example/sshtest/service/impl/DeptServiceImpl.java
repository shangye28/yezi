package com.example.sshtest.service.impl;

import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public PageVO<Dept> findByDeptName(String deptName) {
        PageVO<Dept> p = new PageVO<>();
        p.setList(deptDao.findByDeptName(deptName));
        p.setTotal(deptDao.countByDeptName(deptName));
        return p;
    }

    @Override
    public boolean delete(Integer deptId) {
        Dept role = deptDao.getById(deptId);
        if(role != null){
            deptDao.delete(role);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean save(Dept dept) {
        if(checkDeptNameUnique(dept.getDeptName()) ){
            deptDao.save(dept);
            return true;
        }else
            return false;
    }

    @Override
    public boolean update(Dept dept) {
        if(deptDao.getByDeptName(dept.getDeptName()) != null){
            deptDao.update(dept);
            return true;
        }else
            return false;
    }

    @Override
    public boolean checkDeptNameUnique(String deptName) {
        return false;
    }
}
