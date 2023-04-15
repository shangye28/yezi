package com.example.sshtest.service.impl;



import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.PageDTO;
import com.example.sshtest.pojo.dto.PasswordDTO;
import com.example.sshtest.service.UserService;
import com.example.sshtest.utils.MD5Utils;
import jdk.jfr.TransitionFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public PageDTO<User> findAll() {
        PageDTO<User> p = new PageDTO<>();
        p.setList(userDao.find());
        p.setTotal(userDao.count());
        return p;
    }

    @Override
    public void delete(Integer userId) {
        User user = userDao.getById(userId);
        userDao.delete(user);
    }

    @Override
    @Transactional
    public boolean resetPassword(PasswordDTO pd) {
        User user = userDao.getById(pd.getUserId());
        String oldPassword = MD5Utils.getMD5(pd.getOldP());
        if(pd.getNewP1().equals(pd.getNewP2()) && user.getPassword().equals(oldPassword)){
            String newPassword = MD5Utils.getMD5(pd.getNewP1());
            user.setPassword(newPassword);
            userDao.update(user);
            return true;
        }else
            return false;
    }

    @Override
    public boolean checkUsernameUnique(String username) {
        if(userDao.getByUsername(username) == null)
            return true;
        else
            return false;
    }

    @Override
    public boolean checkEmailUnique(String email) {
//        if(userDao.getByEmail(email) == null)
//            return true;
//        else
//            return false;
        return false;
    }

    @Override
    public boolean checkPhoneUnique(String phone) {
//        if(userDao.getByPhone(phone) == null)
//            return true;
//        else
//            return false;
        return false;
    }
}
