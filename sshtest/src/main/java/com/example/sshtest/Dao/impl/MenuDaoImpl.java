package com.example.sshtest.dao.impl;


import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import org.springframework.stereotype.Repository;

@Repository("MenuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {
}
