package com.example.demo.service;

import com.example.demo.domain.DeptEntity;
import com.example.demo.domain.vo.PageVO;
import java.util.List;

public interface DeptService extends BaseService<DeptEntity> {
    public PageVO<DeptEntity> findByDeptName(String deptName);

    public List<DeptEntity> treeList();

    public boolean checkDeptNameUnique(String deptName);
}
