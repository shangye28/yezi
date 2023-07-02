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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
//    /*推荐使用  */
//    @RequestMapping("/getUserInfo2")
//    public Object getUserInfo2() {
//        /*从安全上下文中获取 用户 认证对象（用户信息）*/-
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal();
//        return principal;
//    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/fail")
    public String fail(){
        return "fail";
    }

//    /**
//     * 获取用户信息
//     *
//     * @return 用户信息
//     */
//    @GetMapping("getInfo")
//    public R getInfo()
//    {
//        User user = SecurityUtils.getLoginUser().getUser();
//        // 角色集合
//        Set<String> roles = permissionService.getRolePermission(user);
//        // 权限集合
//        Set<String> permissions = permissionService.getMenuPermission(user);
//        AjaxResult ajax = AjaxResult.success();
//        ajax.put("user", user);
//        ajax.put("roles", roles);
//        ajax.put("permissions", permissions);
//        return ajax;
//    }

//
//    @PostMapping(value = "/login")
//    public R login(@RequestBody LoginDTO loginDTO) {
//        return userService.login(loginDTO);
//    }
}
