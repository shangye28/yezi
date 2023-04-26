package com.example.sshtest.controller;


import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.pojo.dto.PasswordDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/view")
//    @PreAuthorize(value = "hasAuthority('user:view')")
    public R<PageVO<User>> findAll(){
        return R.SUCCESS(userService.findAll());
    }



    @GetMapping("/findByUsername")
    public R<PageVO<User>> findByUsername(String username){
        return R.SUCCESS(userService.findByUsername(username));
    }

    @GetMapping("/findByNickname")
    public R<PageVO<User>> findByNickname(@RequestBody User user){
        return R.SUCCESS(userService.findByNickname(user.getNickname()));
    }

    @GetMapping("/findByDeptName")
    public R<PageVO<User>> findByDept(@RequestBody Dept dept){
        return R.SUCCESS(userService.findByDeptName(dept.getDeptName()));
    }

    @GetMapping("/getByUsername")
    public R<User> getByUsername(String username){
        return R.SUCCESS(userService.getByUsername(username));
    }


//    @RequestMapping("/resetPwd")
//    public R resetPwd(@RequestBody PasswordDTO pd){
//        if(userService.resetPassword(pd))
//            return R.SUCCESS();
//        else
//            return R.FAIL();
//    }

    @DeleteMapping("/delete")
    public R deleteUser(@RequestBody User user){
        if(userService.delete(user.getUserId()))
            return R.SUCCESS();
        else
            return R.FAIL();

    }
//    @RequiresPermissions("user:delete")
    @PostMapping("/save")
    public R saveUser(@RequestBody User user){
        if(userService.save(user))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PutMapping("/update")
    public R updateUser(@RequestBody User user){
        if(userService.update(user))
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
