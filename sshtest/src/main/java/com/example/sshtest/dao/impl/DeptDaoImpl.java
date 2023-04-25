package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.utils.CRUDUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository("DeptDao")
public class DeptDaoImpl extends BaseDaoImpl<Dept> implements DeptDao {
    @Override
    public List<Dept> findByDeptName(String deptName) {
        CRUDUtils<Dept> crudUtils = new CRUDUtils<>();
        String hql = "from Dept where dept_name like :deptName";
        String n = "%" + deptName + "%";
        Query query = this.entityManager.createQuery(hql, Dept.class);
        return crudUtils.find(query, "deptName", n);
    }

    @Override
    public Long countByDeptName(String deptName) {
        String hql = "select count(*) from Dept where dept_name like :deptName";
        String n = "%" + deptName + "%";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("deptName",n);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public Dept getByDeptName(String deptName) {
        CRUDUtils<Dept> crudUtils = new CRUDUtils<>();
        String hql = "from Dept where dept_name=:menuName";
        Query q = this.entityManager.createQuery(hql, Dept.class);
        return crudUtils.get(q, "deptName", deptName);
    }
}
