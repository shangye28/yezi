package com.example.sshtest.service;

import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;

public interface MenuService extends BaseService<Menu> {
    public PageVO<Menu> findByMenuName(String menuName);

    public boolean checkMenuNameUnique(String menuName);
}
