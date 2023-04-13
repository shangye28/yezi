package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuDaoImpl implements MenuDao {

    private BaseDao<Menu> baseDao;

    public BaseDao<Menu> getBaseDao() {
        return baseDao;
    }
    @Autowired
    public void setBaseDao(BaseDao<Menu> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public List<Menu> findByAll() {
        String hql = "from Menu";
        return baseDao.find(hql, Menu.class);
    }

    @Override
    public List<Menu> findByMenuName(String menuName) {
        String hql = "from Menu where menu_name like :menuName";
        String n = "%" + menuName + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("menuName",n);
        return baseDao.find(hql, m, Menu.class);
    }

    @Override
    public List<Menu> findByStatus(String status) {
        String hql = "from Menu where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",status);
        return baseDao.find(hql, m, Menu.class);
    }
    @Override
    public Long countAll(){
        String hql = "select count(*) from Menu";
        return baseDao.count(hql);
    }

    @Override
    public Long countMenuName(String str){
        String hql = "select count(*) from Menu where menu_name like :menuName";
        String n = "%" + str + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("menuName",n);
        return baseDao.count(hql, m);
    }

    @Override
    public Long countStatus(String str){
        String hql = "select count(*) from Menu where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",str);
        return baseDao.count(hql, m);
    }

    @Override
    public void delete(Menu menu) {
        baseDao.delete(menu);
    }

    @Override
    public void save(Menu menu) {
        baseDao.save(menu);
    }

    @Override
    public void updata(Menu menu){
        baseDao.update(menu);
    }

}
