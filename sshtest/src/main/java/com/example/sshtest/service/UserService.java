package com.example.sshtest.service;


import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.PageDTO;
import com.example.sshtest.pojo.dto.PasswordDTO;

import javax.persistence.criteria.CriteriaBuilder;


public interface UserService{
    public PageDTO<User> findAll();
    public void delete(Integer userId);

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

    /**
     * 检验邮箱是否唯一
     *
     * @param email
     * @return
     */
    public boolean checkEmailUnique(String email);

    /**
     * 检验手机号是否唯一
     *
     * @param Phone
     * @return
     */
    public boolean checkPhoneUnique(String Phone);

}