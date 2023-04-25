package com.example.sshtest.dao;

import com.example.sshtest.pojo.Dept;

import java.util.List;

public interface DeptDao extends BaseDao<Dept> {
    public List<Dept> findByDeptName(String deptName);

    public Long countByDeptName(String deptName);

    public Dept getByDeptName(String deptName);
}
