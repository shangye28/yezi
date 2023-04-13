package com.example.sshtest.controller;

import com.example.sshtest.Service.UserService;
import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.LoginDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.utils.JWTUtils;
import com.example.sshtest.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    /**
     * 登录验证
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public R userLogin(@RequestBody LoginDTO loginDTO){
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
//        password = MD5Utils.getMD5(password);
        User user= userDao.getByUsername(username);
        if(user.getPassword().equals(password)){ //登录成功
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

    /**
     * 查找user所有
     * @return
     */
    @RequestMapping("/userAll")
    public R findAll(){
        Pager<User> p = userService.findAll();
        if(p.getData() != null)
            return R.SUCCESS(p);
        else
            return R.FAIL();
    }
    /**
     * 根据username模糊匹配查找
     * @return
     */
    @RequestMapping("/userName")
    public R findByUsername(@RequestBody User user){
        Pager<User> p = userService.findByUsername(user.getUsername());
        if(p.getData() != null)
            return R.SUCCESS(p);
        else
            return R.FAIL();
    }
    /**
     * 根据nickname模糊匹配查找
     * @return
     */
    @RequestMapping("/userName")
    public R findByNickname(@RequestBody User user){
        Pager<User> p = userService.findByNickname(user.getNickname());
        if(p.getData() != null)
            return R.SUCCESS(p);
        else
            return R.FAIL();
    }

    /**
     * 删除对象
     * @param user
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteUser(@RequestBody User user){
        if(user.getUserId() != null){
            userDao.delete(user);
            return R.SUCCESS();
        }else
            return R.FAIL();
    }

    /**
     * 更新对象
     * @param user
     * @return
     */
    @RequestMapping("/updata")
    public R updataUser(@RequestBody User user){
        if(user.getUserId() != null){
            userDao.updata(user);
            return R.SUCCESS();
        }else
            return R.FAIL();
    }
    @RequestMapping("/add")
    public R addUser(@RequestBody User user){
        if(user.getUsername() != null && user.getPassword() != null){
            userDao.save(user);
            return R.SUCCESS();
        }else
            return R.FAIL();
    }
//    @RequestMapping("/toRegister")
//    public void register(User user, HttpServletResponse response) throws IOException {
//        Iterable<User> iterable = userService.findAll();
//        for (User user1 : iterable) {
//            System.out.println(user1.toString());
//        }
//        // 随便跳个网页
//        response.sendRedirect("http://www.baidu.com");
//    }
//    /**
//     * @作用 用户登录
//     * @参数说明
//     * @return
//     */


//    @GetMapping("/userSelect")
//    public R userAll(@RequestBody User user){
//        if(user.getUsername() != null){
//            return R.SUCCESS(userService.findByUsername(user.getUsername()));
//        }else if(user.getNickname() != null){
//            return R.SUCCESS(userService.findByNickname(user.getNickname()));
//        }else{
//            return R.FAIL();
//        }
//    }
//    /**
//     * @作用 根据id删除信息
//     * @参数说明
//     * @return
//     */
//    @DeleteMapping("/del/{id}")
//    public R userDelete(@PathVariable Integer id){
//        return R.SUCCESS();
//    }
}
