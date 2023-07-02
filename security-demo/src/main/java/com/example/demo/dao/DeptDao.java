package com.example.demo.dao;

import com.example.demo.domain.DeptEntity;
import java.util.List;

public interface DeptDao extends BaseDao<DeptEntity> {
    public List<DeptEntity> findByDeptName(String deptName);

    public List<DeptEntity> treeList();

    public Long countByDeptName(String deptName);

    public DeptEntity getByDeptName(String deptName);
}
