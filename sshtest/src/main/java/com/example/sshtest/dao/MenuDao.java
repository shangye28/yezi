package com.example.sshtest.dao;


import com.example.sshtest.pojo.Menu;

import java.util.List;

public interface MenuDao extends BaseDao<Menu> {
    public List<Menu> findByMenuName(String menuName);

    public List<Menu> treeList();

    public Long countByMenuName(String menuName);

    public Menu getByMenuName(String menuName);
}
