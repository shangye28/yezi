package com.example.sshtest.service.impl;

import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public PageVO<Menu> findAll() {
        PageVO<Menu> p = new PageVO<>();
        p.setList(menuDao.find());
        p.setTotal(menuDao.count());
        return p;
    }
}
