package com.example.sshtest.service.impl;

import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public PageVO<Menu> findByMenuName(String menuName) {
        PageVO<Menu> p = new PageVO<>();
        p.setList(menuDao.findByMenuName(menuName));
        p.setTotal(menuDao.countByMenuName(menuName));
        return p;
    }

    @Override
    public List<Menu> treeList() {
        return menuDao.treeList();
    }


    @Override
    public boolean checkMenuNameUnique(String menuName) {
        return false;
    }
}
