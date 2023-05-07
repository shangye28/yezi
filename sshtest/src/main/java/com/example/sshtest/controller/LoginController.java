package com.example.sshtest.controller;

import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.LoginDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.UserService;
import com.example.sshtest.utils.JWTUtils;
import com.example.sshtest.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService ;

//    @Autowired
//    private PasswordEncoder passwordEncoder ;
    /**
     * 登录验证
     *
     * @param loginDTO
     * @return
     */
    @RequestMapping("/login")
    public R userLogin(@RequestBody LoginDTO loginDTO){
        String username = loginDTO.getUsername();
        String p = loginDTO.getPassword();
        //密码加密
        String password = MD5Utils.getMD5(p);
        User user= userDao.getByUsername(username);
        if(user != null && user.getPassword().equals(password)){ //登录成功
            //设置token
            Map<String,String> hm = new HashMap<>();
            hm.put("username",username);
            hm.put("userId",String.valueOf(user.getUserId()));
            String token = JWTUtils.getToken(hm);
            loginDTO.setUserToken(token);
//            loginDTO.setMenus(userService.menuByName(username));
            return R.SUCCESS(loginDTO);
        }else{
            return R.FAIL();
        }
    }

//
//    @PostMapping(value = "/login")
//    public R login(@RequestBody LoginDTO loginDTO) {
//        return userService.login(loginDTO);
//    }
}
