package com.example.sshtest.dao;

import com.example.sshtest.pojo.Dept;

import java.util.List;

public interface DeptDao {
    public List<Dept> findByAll();
    public List<Dept> findByDeptName(String deptName);
    public List<Dept> findByStatus(String status);
//    public Dept getByDeptId(Integer id);
    public Long countAll();
    public Long countDeptName(String str);
    public Long countStatus(String str);
    public void delete(Dept dept);
    public void save(Dept dept);
    public void updata(Dept dept);
}
