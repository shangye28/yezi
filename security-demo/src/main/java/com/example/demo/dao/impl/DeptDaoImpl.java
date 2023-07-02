package com.example.demo.dao.impl;

import com.example.demo.dao.DeptDao;
import com.example.demo.domain.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

@Repository("DeptDao")
public class DeptDaoImpl extends BaseDaoImpl<DeptEntity> implements DeptDao {
    @Autowired
    private NativeQuery<DeptEntity> nativeQuery;

    @Override
    public List<DeptEntity> findByDeptName(String deptName) {
        String hql = "from DeptEntity where dept_name like concat('%', :deptName, '%')";
        return nativeQuery.find(hql,"deptName", deptName, DeptEntity.class);
    }

    @Override
    public List<DeptEntity> treeList() {
        String hql = "from DeptEntity where dept_id = 1";
        Query query = this.entityManager.createQuery(hql, DeptEntity.class);
        List<DeptEntity> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Long countByDeptName(String deptName) {
        String hql = "select count(*) from DeptEntity where dept_name like :deptName";
        String n = "%" + deptName + "%";
        Query q = this.entityManager.createQuery(hql);
        q.setParameter("deptName",n);
        Long total = (Long) q.getSingleResult();
        return total;
    }

    @Override
    public DeptEntity getByDeptName(String deptName) {
        String hql = "from DeptEntity where dept_name=:menuName";
        return nativeQuery.get(hql,"deptName", deptName, DeptEntity.class);
    }
}
