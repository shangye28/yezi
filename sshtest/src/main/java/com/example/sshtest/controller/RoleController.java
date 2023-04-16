package com.example.sshtest.controller;


import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.dto.PageDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleService roleService;

//    @RequestMapping("/test")
//    public R test(@RequestBody User user){
//        User user1 = userDao.getByUsername(user.getUsername());
//        if (user1 != null)
//            return R.SUCCESS(user1);
//        else
//            return R.FAIL();
//    }

    @GetMapping("/view")
    public R<PageDTO<Role>> findAll(){
        return R.SUCCESS(roleService.findAll());
    }

}
