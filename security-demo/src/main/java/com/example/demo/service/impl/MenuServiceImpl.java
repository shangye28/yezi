package com.example.demo.service.impl;

import com.example.demo.dao.MenuDao;
import com.example.demo.domain.MenuEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuEntity> implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public PageVO<MenuEntity> findByMenuName(String menuName) {
        PageVO<MenuEntity> p = new PageVO<>();
        p.setList(menuDao.findByMenuName(menuName));
        p.setTotal(menuDao.countByMenuName(menuName));
        return p;
    }

    @Override
    public List<MenuEntity> treeList() {
        return menuDao.treeList();
    }

    @Override
    public boolean checkMenuNameUnique(String menuName) {
        return false;
    }
}