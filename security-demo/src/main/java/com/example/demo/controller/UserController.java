package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.DeptEntity;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.result.R;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @GetMapping("/view")
    @PreAuthorize(value = "hasAuthority('user:view')")
    public R<PageVO<UserEntity>> findAll(){
        return R.SUCCESS(userService.findAll());
    }

    @GetMapping("/findByName")
    @PreAuthorize(value = "hasAuthority('user:list')")
    public R<PageVO<UserEntity>> findByName(String username, String nickname){
        return R.SUCCESS(userService.findByName(username, nickname));
    }

    @GetMapping("/findByDeptName")
    @PreAuthorize(value = "hasAuthority('user:list')")
    public R<PageVO<UserEntity>> findByDept(@RequestBody DeptEntity dept){
        return R.SUCCESS(userService.findByDeptName(dept.getDeptName()));
    }

    @GetMapping("/getByUsername")
    public R<UserEntity> getByUsername(String username){
        return R.SUCCESS(userService.getByUsername(username));
    }


    @PostMapping("/add")
    @PreAuthorize(value = "hasAuthority('user:add')")
    public R saveUser(@RequestBody UserEntity user){
        user.setCreateTime(LocalDateTime.now());
        userService.save(user);
        return R.SUCCESS();
    }

    @PutMapping("/edit")
    @PreAuthorize(value = "hasAuthority('user:edit')")
    public R updateUser(@RequestBody UserEntity user){
        userService.update(user);
        return R.SUCCESS();
    }

    @DeleteMapping("/remove")
    @PreAuthorize(value = "hasAuthority('user:remove')")
    public R deleteUser(String username){
        System.out.println(username);
        UserEntity user1 = userDao.getByUsername(username);
        userService.delete(user1);
        return R.SUCCESS();
    }
}