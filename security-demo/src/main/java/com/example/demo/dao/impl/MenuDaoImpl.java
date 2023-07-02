package com.example.demo.dao.impl;

import com.example.demo.dao.MenuDao;
import com.example.demo.domain.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

@Repository("MenuDao")
public class MenuDaoImpl extends BaseDaoImpl<MenuEntity> implements MenuDao {
    @Autowired
    private NativeQuery<MenuEntity> nativeQuery;

    @Override
    public List<MenuEntity> findByMenuName(String menuName) {
        String hql = "from MenuEntity where menu_name like concat('%', :menuName, '%')";
        return nativeQuery.find(hql,"menuName", menuName, MenuEntity.class);
    }

    @Override
    public List<MenuEntity> treeList() {
        String hql = "from MenuEntity where menu_type = 'M'";
        Query query = this.entityManager.createQuery(hql, MenuEntity.class);
        List<MenuEntity> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Long countByMenuName(String menuName) {
        String hql = "select count(*) from MenuEntity where menu_name like :menuName";
        String n = "%" + menuName + "%";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("menuName",n);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public MenuEntity getByMenuName(String menuName) {
        String hql = "from MenuEntity where menu_name=:menuName";
        return nativeQuery.get(hql,"menuName", menuName, MenuEntity.class);
    }
}
