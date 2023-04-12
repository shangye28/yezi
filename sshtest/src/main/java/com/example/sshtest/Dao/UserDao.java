package com.example.sshtest.dao;

import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.User;

import java.util.List;


public interface UserDao {
    public List<User> findByAll();
    public List<User> findByUsername(String username);
    public List<User> findByNickname(String nickname);
    public User getByUsername(String username);
    public void delete(User user);
    public void save(User user);
    public void updata(User user);
}
