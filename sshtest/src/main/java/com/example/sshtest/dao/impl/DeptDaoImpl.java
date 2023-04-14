package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import org.springframework.stereotype.Repository;


@Repository("DeptDao")
public class DeptDaoImpl extends BaseDaoImpl<Dept> implements DeptDao {
}
