package com.example.sshtest.controller;

import com.example.sshtest.Service.UserService;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.LoginDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @RequestMapping("/toRegister")
//    public void register(User user, HttpServletResponse response) throws IOException {
//        Iterable<User> iterable = userService.findAll();
//        for (User user1 : iterable) {
//            System.out.println(user1.toString());
//        }
//        // 随便跳个网页
//        response.sendRedirect("http://www.baidu.com");
//    }
    /**
     * @作用 用户登录
     * @参数说明
     * @return
     */
    @PostMapping("/login")
    public R userLogin(@RequestBody LoginDTO loginDTO){
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
//        password = MD5Utils.getMD5(password);
        User user = userService.findByUsername(username);
        if(user.getPassword().equals(password)){ //登录成功
            //设置token
            Map<String,String> hm = new HashMap<>();
            hm.put("username",username);
            hm.put("userId",String.valueOf(user.getUserId()));
            String token = JWTUtils.getToken(hm);
            loginDTO.setUserToken(token);
//            loginDTO.setMenus(userService.menuByName(username));
            return R.SUCCESS(loginDTO);
        }else {
            return R.FAIL();
        }

    }
    /**
     * @作用 查找所有账号信息接口
     * @参数说明
     * @return
     */
    @GetMapping("/userAll")
    public R<Iterable<User>> userAll(){
            return R.SUCCESS(userService.findAll());

    }
    @GetMapping("/userSelect")
    public R userAll(@RequestBody User user){
        if(user.getUsername() != null){
            return R.SUCCESS(userService.findByUsername(user.getUsername()));
        }else if(user.getNickname() != null){
            return R.SUCCESS(userService.findByNickname(user.getNickname()));
        }else{
            return R.FAIL();
        }
    }
    /**
     * @作用 根据id删除信息
     * @参数说明
     * @return
     */
    @DeleteMapping("/del/{id}")
    public R userDelete(@PathVariable Integer id){
        return R.SUCCESS();
    }
}
