package com.example.sshtest.service;

import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.dto.PageDTO;

public interface MenuService {
    public PageDTO<Menu> findAll();
}
