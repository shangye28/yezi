package com.example.sshtest.service;

import com.example.sshtest.pojo.vo.PageVO;

public interface BaseService<T> {
    public PageVO<T> findAll();
}
