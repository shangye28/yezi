package com.example.sshtest.service;

import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;

public interface DeptService extends BaseService<Dept> {
    public PageVO<Dept> findByDeptName(String deptName);

    public boolean delete(Integer deptId);
    public boolean save(Dept dept);
    public boolean update(Dept dept);

    public boolean checkDeptNameUnique(String deptName);
}
