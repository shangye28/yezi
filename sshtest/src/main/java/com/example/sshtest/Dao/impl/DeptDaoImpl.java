package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptDaoImpl implements DeptDao {
    private BaseDao<Dept> baseDao;

    public BaseDao<Dept> getBaseDao() {
        return baseDao;
    }
    @Autowired
    public void setBaseDao(BaseDao<Dept> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public List<Dept> findByAll() {
        String hql = "from Dept";
        return baseDao.find(hql, Dept.class);
    }

    @Override
    public List<Dept> findByDeptName(String deptName) {
        String hql = "from Dept where dept_name like :deptName";
        String n = "%" + deptName + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("deptName",n);
        return baseDao.find(hql, m, Dept.class);
    }

    @Override
    public List<Dept> findByStatus(String status) {
        String hql = "from Dept where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",status);
        return baseDao.find(hql, m, Role.class);
    }

//    @Override
//    public Dept getByDeptId(Integer id) {
//        String hql = "from Role where dept_id=:id";
//        Map<String,Object> m = new HashMap<>();
//        m.put("id",id);
//        return baseDao.get(hql, m ,Dept.class);
//    }

    @Override
    public Long countAll(){
        String hql = "select count(*) from Dept";
        return baseDao.count(hql);
    }

    @Override
    public Long countDeptName(String str){
        String hql = "select count(*) from Dept where dept_name like :deptName";
        String n = "%" + str + "%";
        Map<String,Object> m = new HashMap<>();
        m.put("deptName",n);
        return baseDao.count(hql, m);
    }

    @Override
    public Long countStatus(String str){
        String hql = "select count(*) from Dept where status=:status";
        Map<String,Object> m = new HashMap<>();
        m.put("status",str);
        return baseDao.count(hql, m);
    }

    @Override
    public void delete(Dept dept) {
        baseDao.delete(dept);
    }

    @Override
    public void save(Dept dept) {
        baseDao.save(dept);
    }

    @Override
    public void updata(Dept dept) {
        baseDao.update(dept);
    }
}
