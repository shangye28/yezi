package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.utils.CRUDUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("MenuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {
    @Override
    public List<Menu> findByMenuName(String menuName) {
        CRUDUtils<Menu> crudUtils = new CRUDUtils<>();
        String hql = "from Menu where menu_name like :menuName";
        String n = "%" + menuName + "%";
        Query query = this.entityManager.createQuery(hql, Menu.class);
        return crudUtils.find(query, "menuName", n);
    }

    @Override
    public Long countByMenuName(String menuName) {
        String hql = "select count(*) from Menu where menu_name like :menuName";
        String n = "%" + menuName + "%";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("menuName",n);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Menu getByMenuName(String menuName) {
        CRUDUtils<Menu> crudUtils = new CRUDUtils<>();
        String hql = "from Menu where menu_name=:menuName";
        Query q = this.entityManager.createQuery(hql, Menu.class);
        return crudUtils.get(q, "menuName", menuName);
    }
}
