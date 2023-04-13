package com.example.sshtest.dao;


import com.example.sshtest.pojo.Menu;
import java.util.List;

public interface MenuDao {
    public List<Menu> findByAll();
    public List<Menu> findByMenuName(String menuName);
    public List<Menu> findByStatus(String status);
//    public Menu getByMenuId(Integer id);
    public Long countAll();
    public Long countMenuName(String str);
    public Long countStatus(String str);
    public void delete(Menu menu);
    public void save(Menu menu);
    public void updata(Menu menu);
}
