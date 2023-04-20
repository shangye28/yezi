package com.example.sshtest.service;

import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;

public interface DeptService {
    public PageVO<Dept> findAll();
}
