package com.example.sshtest.service;

import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;

public interface MenuService extends BaseService<Menu> {
    public PageVO<Menu> findByMenuName(String menuName);

    public boolean delete(Integer menuId);
    public boolean save(Menu menu);
    public boolean update(Menu menu);

    public boolean checkMenuNameUnique(String menuName);
}
