package com.example.demo.service;

import com.example.demo.domain.MenuEntity;
import com.example.demo.domain.vo.PageVO;
import java.util.List;

public interface MenuService extends BaseService<MenuEntity> {
    public PageVO<MenuEntity> findByMenuName(String menuName);

    public List<MenuEntity> treeList();

    public boolean checkMenuNameUnique(String menuName);
}
