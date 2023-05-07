package com.example.sshtest.service.impl;



import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.LoginDTO;
//import com.example.sshtest.pojo.vo.LoginUser;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.pojo.dto.PasswordDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
//    @Autowired
//    private AuthenticationManager authenticationManager ;
    @Autowired
    private UserDao userDao;


    /**
     * 根据用户名或昵称查询用户
     * @param username
     * @return
     */
    @Override
    public PageVO<User> findByName(String username, String nickname) {
        PageVO<User> p = new PageVO<>();
        if(username != null){
            p.setList(userDao.findByUsername(username));
            p.setTotal(userDao.countByUsername(username));
        }else{
            p.setList(userDao.findByNickname(nickname));
            p.setTotal(userDao.countByNickname(nickname));
        }
        return p;
    }

    /**
     * 部门筛选用户信息
     * @param deptName
     * @return
     */
    @Override
    public PageVO<User> findByDeptName(String deptName) {
        PageVO<User> p = new PageVO<>();
        p.setList(userDao.findByDeptName(deptName));
        p.setTotal(userDao.countByDeptName(deptName));
        return p;
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }



//    @Override
//    @Transactional
//    public boolean resetPassword(PasswordDTO pd) {
//        User user = userDao.getById(pd.getUserId());
//        String oldPassword = passwordEncoder.encode(pd.getOldP());
//        if(pd.getNewP1().equals(pd.getNewP2()) && user.getPassword().equals(oldPassword)){
//            String newPassword = passwordEncoder.encode(pd.getNewP1());
//            user.setPassword(newPassword);
//            userDao.update(user);
//            return true;
//        }else
//            return false;
//    }

    /**
     * 检查用户名是否唯一
     * @param username
     * @return
     */
    @Override
    public boolean checkUsernameUnique(String username) {
        if(userDao.getByUsername(username) == null)
            return true;
        else
            return false;
    }




    //    @Autowired
//    private PasswordEncoder passwordEncoder ;

//    @Override
//    public R login(LoginDTO loginDTO) {
//        try{
//            // 创建Authentication对象
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername() , loginDTO.getPassword(), null) ;
//
//            // 调用AuthenticationManager的authenticate方法进行认证
//            Authentication authentication = authenticationManager.authenticate(authenticationToken);
//            if(authentication == null) {
//                return R.FAIL();
//            }
//            User user = userDao.getByUsername(loginDTO.getUsername());
//
////      设置token
//            Map<String,String> hm = new HashMap<>();
//            hm.put("username",user.getUsername());
//            hm.put("userId",String.valueOf(user.getUserId()));
//            String token = JWTUtils.getToken(hm);
//            loginDTO.setUserToken(token);
////            loginDTO.setMenus(userService.menuByName(username));
//
//            List<String> permissions = new ArrayList<>();
//            permissions.add("user:view");
//            return R.SUCCESS(loginDTO);
//        }catch (RuntimeException e){
//            return R.FAIL();
//        }
//    }
//
//    @Override
//    public R loginOut() {
//        // 获取登录的用户信息
//        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Integer userId = loginUser.getUser().getUserId();
//
//        // 返回
//        return R.SUCCESS() ;
//    }
}
