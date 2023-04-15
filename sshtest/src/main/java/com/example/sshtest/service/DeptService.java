package com.example.sshtest.service;

import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.dto.PageDTO;

public interface DeptService {
    public PageDTO<Dept> findAll();
}
