package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository("DeptDao")
public class DeptDaoImpl extends BaseDaoImpl<Dept> implements DeptDao {
    @Autowired
    private NativeQuery<Dept> nativeQuery;
    @Override
    public List<Dept> findByDeptName(String deptName) {
        String hql = "from Dept where dept_name like concat('%', :deptName, '%')";
        return nativeQuery.find(hql,"deptName", deptName, Dept.class);
    }

    @Override
    public List<Dept> treeList() {
        String hql = "from Dept where dept_id = 1";
        Query query = this.entityManager.createQuery(hql, Dept.class);
        List<Dept> resultList = query.getResultList();
        return resultList;
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
        String hql = "from Dept where dept_name=:menuName";
        return nativeQuery.get(hql,"deptName", deptName, Dept.class);
    }
}
