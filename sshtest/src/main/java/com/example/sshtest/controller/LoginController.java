package com.example.sshtest.controller;

import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.LoginDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.UserService;
import com.example.sshtest.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;


    @Autowired
    private UserService userService ;

    @Autowired
    private PasswordEncoder passwordEncoder ;
    /**
     * 登录验证
     *
     * @param loginDTO
     * @return
     */
    @RequestMapping("/login")
    public R userLogin(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO.getUsername());
        System.out.println(loginDTO.getPassword());
        String username = loginDTO.getUsername();
        String p = loginDTO.getPassword();
        //密码加密
        User user= userDao.getByUsername(username);
        if(user != null && passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())){ //登录成功
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
    /*推荐使用  */
    @RequestMapping("/getUserInfo2")
    public Object getUserInfo2() {
        /*从安全上下文中获取 用户 认证对象（用户信息）*/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return principal;
    }

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
