package com.example.sshtest.service;

import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;

import java.util.List;

public interface MenuService extends BaseService<Menu> {
    public PageVO<Menu> findByMenuName(String menuName);
    public List<Menu> treeList();

    public boolean checkMenuNameUnique(String menuName);
}
