package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserEntity;
import com.example.demo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping("/index")
public class Login {

      @Autowired
      private UserDao userDao;

    @Autowired
    private JWTUtils jwtUtils;

    @Value("Bearer")
    private String tokenHead;

    @PostMapping("/admin/login")
    public String login(@RequestBody UserEntity user, HttpServletRequest request) {
        /* 在这里验证用户名和密码，验证成功则生成token返回 */
        System.out.println("--- -- -login");
        System.out.println(user);
        return  tokenHead+" "+jwtUtils.generateToken(user.getUsername());  // 生成 Token，返回给客户端
    }


      @PreAuthorize("hasRole('Admin') and authentication.name=='admin'")
      @RequestMapping("/helloword1")
      public String hello1(){
        return "111!";
      }

      @PreAuthorize("hasRole('Admin')")
      @RequestMapping("/helloword2")
      public String hello2(){
        return "222!";
      }

      @PreAuthorize("hasAuthority('analysis:view')")
      @RequestMapping("/helloword3")
      public String hello3(){
        return "333!";
      }

      @RequestMapping("/public/helloword4")
      public String hello4(){
          return "444!";
      }
}
