package com.example.sshtest.service;

import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;

import java.util.List;

public interface DeptService extends BaseService<Dept> {
    public PageVO<Dept> findByDeptName(String deptName);

    public List<Dept> treeList();
    public boolean checkDeptNameUnique(String deptName);
}
