package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("MenuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {
    @Autowired
    private NativeQuery<Menu> nativeQuery;
    @Override
    public List<Menu> findByMenuName(String menuName) {
        String hql = "from Menu where menu_name like concat('%', :menuName, '%')";
        return nativeQuery.find(hql,"menuName", menuName, Menu.class);
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
        String hql = "from Menu where menu_name=:menuName";
        return nativeQuery.get(hql,"menuName", menuName, Menu.class);
    }
}
