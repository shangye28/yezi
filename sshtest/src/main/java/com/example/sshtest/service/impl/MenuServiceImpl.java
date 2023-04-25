package com.example.sshtest.service.impl;

import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean delete(Integer menuId) {
        Menu role = menuDao.getById(menuId);
        if(role != null){
            menuDao.delete(role);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean save(Menu menu) {
        if(checkMenuNameUnique(menu.getMenuName()) ){
            menuDao.save(menu);
            return true;
        }else
            return false;
    }

    @Override
    public boolean update(Menu menu) {
        if(menuDao.getByMenuName(menu.getMenuName()) != null){
            menuDao.update(menu);
            return true;
        }else
            return false;
    }

    @Override
    public boolean checkMenuNameUnique(String menuName) {
        return false;
    }
}
