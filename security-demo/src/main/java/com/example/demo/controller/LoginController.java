package com.example.demo.controller;


import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.dto.LoginDTO;
import com.example.demo.result.R;
import com.example.demo.service.UserService;
import com.example.demo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Value("Bearer")
    private String tokenHead;

    /**
     * 登录验证
     *
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {
        /* 在这里验证用户名和密码，验证成功则生成token返回 */
        System.out.println("--- -- -login");
        System.out.println(loginDTO);
        String username = loginDTO.getUsername();
        UserEntity user= userDao.getByUsername(username);
        if(user != null && passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())){
            String token = tokenHead+" "+jwtUtils.generateToken(loginDTO.getUsername());
            loginDTO.setUserToken(token);
            return R.SUCCESS(loginDTO);
        }
        return  R.FAIL();
    }

    @PostMapping("/logout")
    public R logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate(); // 清空会话
        }
        response.setHeader("Authorization", ""); // 清空Token
        return  R.SUCCESS();
    }

}
