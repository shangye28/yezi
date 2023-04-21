package com.example.sshtest.service.impl;



import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.pojo.dto.PasswordDTO;
import com.example.sshtest.pojo.dto.UserinfoDTO;
import com.example.sshtest.service.UserService;
import com.example.sshtest.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageVO<User> findByUsername(String username) {
        PageVO<User> p = new PageVO<>();
        p.setList(userDao.findByUsername(username));
        p.setTotal(userDao.countByUsername(username));
        return p;
    }

    @Override
    public PageVO<User> findByNickname(String nickname) {
        PageVO<User> p = new PageVO<>();
        p.setList(userDao.findByNickname(nickname));
        p.setTotal(userDao.countByNickname(nickname));
        return p;
    }

    @Override
    public PageVO<User> findByDeptName(String deptName) {
        PageVO<User> p = new PageVO<>();
        p.setList(userDao.findByDeptName(deptName));
        p.setTotal(userDao.countByDeptName(deptName));
        return p;
    }


    @Override
    @Transactional
    public boolean delete(Integer userId) {
        User user = userDao.getById(userId);
        if(user != null){
            userDao.delete(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public boolean save(User user) {
        if(checkUsernameUnique(user.getUsername()) ){
            userDao.save(user);
            return true;
        }else
            return false;
    }


    @Override
    @Transactional
    public boolean update(User user) {
        if(userDao.getByUsername(user.getUsername()) != null){
            userDao.update(user);
            return true;
        }else
            return false;
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
}
