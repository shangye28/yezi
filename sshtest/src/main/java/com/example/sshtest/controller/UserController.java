package com.example.sshtest.controller;


import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.dto.PageDTO;
import com.example.sshtest.pojo.dto.PasswordDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public R test(@RequestBody User user){
        User user1 = userDao.getByUsername(user.getUsername());
        if (user1 != null)
            return R.SUCCESS(user1);
        else
            return R.FAIL();
    }

//    @RequiresPermissions("user:view")
//    @GetMapping
    @RequestMapping("/view")
    public R<PageDTO<User>> findAll(){
        PageDTO<User> p = new PageDTO<>();
        p.setList(userDao.find());
        p.setTotal(userDao.count());
        return R.SUCCESS(p);
    }


    @RequestMapping("/resetPwd")
    public R resetPwd(@RequestBody PasswordDTO pd){
        if(userService.resetPassword(pd))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

//    /**
//     * 查找user所有
//     * @return
//     */
//    @RequestMapping("/userAll")
//    public R findAll(){
//        Pager<User> p = userService.findAll();
//        if(p.getData() != null)
//            return R.SUCCESS(p);
//        else
//            return R.FAIL();
//    }
//    /**
//     * 根据username模糊匹配查找
//     * @return
//     */
//    @RequestMapping("/userName")
//    public R findByUsername(@RequestBody User user){
//        Pager<User> p = userService.findByUsername(user.getUsername());
//        if(p.getData() != null)
//            return R.SUCCESS(p);
//        else
//            return R.FAIL();
//    }
//    /**
//     * 根据nickname模糊匹配查找
//     * @return
//     */
//    @RequestMapping("/nickName")
//    public R findByNickname(@RequestBody User user){
//        Pager<User> p = userService.findByNickname(user.getNickname());
//        if(p.getData() != null)
//            return R.SUCCESS(p);
//        else
//            return R.FAIL();
//    }
//
//    /**
//     * 删除对象
//     * @param user
//     * @return
//     */
//    @DeleteMapping("/delete")
//    public R deleteUser(@RequestBody User user){
//        if(user.getUserId() != null){
//            userDao.delete(user);
//            return R.SUCCESS();
//        }else
//            return R.FAIL();
//    }
//
//    /**
//     * 更新对象
//     * @param user
//     * @return
//     */
//    @RequestMapping("/updata")
//    public R updataUser(@RequestBody User user){
//        if(user.getUserId() != null){
//            userDao.updata(user);
//            return R.SUCCESS();
//        }else
//            return R.FAIL();
//    }
//    @RequestMapping("/add")
//    public R addUser(@RequestBody User user){
//        if(user.getUsername() != null && user.getPassword() != null){
//            userDao.save(user);
//            return R.SUCCESS();
//        }else
//            return R.FAIL();
//    }
}
