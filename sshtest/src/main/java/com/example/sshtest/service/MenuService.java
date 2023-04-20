package com.example.sshtest.service;

import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;

public interface MenuService {
    public PageVO<Menu> findAll();
}
