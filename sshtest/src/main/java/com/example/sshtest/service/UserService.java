package com.example.sshtest.service;


import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.pojo.dto.PasswordDTO;
import com.example.sshtest.pojo.dto.UserinfoDTO;


public interface UserService{
    public PageVO<User> findAll();
    public PageVO<User> findByUsername(String username);
    public PageVO<User> findByNickname(String username);
    public boolean delete(Integer userId);
    public boolean save(User user);
    public boolean update(UserinfoDTO userinfoDTO);

    /**
     * 修改密码
     *
     * @param pd
     */
    public boolean resetPassword(PasswordDTO pd);

    /**
     * 检验用户名是否唯一
     *
     * @param username
     * @return
     */
    public boolean checkUsernameUnique(String username);


}