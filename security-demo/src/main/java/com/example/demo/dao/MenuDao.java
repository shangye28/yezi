package com.example.demo.dao;

import com.example.demo.domain.MenuEntity;
import java.util.List;

public interface MenuDao extends BaseDao<MenuEntity> {
    public List<MenuEntity> findByMenuName(String menuName);

    public List<MenuEntity> treeList();

    public Long countByMenuName(String menuName);

    public MenuEntity getByMenuName(String menuName);
}
