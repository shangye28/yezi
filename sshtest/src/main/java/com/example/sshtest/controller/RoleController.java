package com.example.sshtest.controller;


import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import com.example.sshtest.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
//    @Autowired
//    private RoleService roleService;
    @Autowired
    private RoleDao roleDao;

//    /**
//     * 查找role所有
//     * @return
//     */
//    @RequestMapping("/roleAll")
//    public R findAll(){
//        List<Role> list = roleDao.findByAll();
//        if(list != null)
//            return R.SUCCESS(list);
//        else
//            return R.FAIL();
//    }
//    @RequestMapping("/roleName")
//    public R selectRoleName(@RequestBody Role role){
//        List<Role> list = roleDao.findByStatus(role.getStatus());
//        if(list != null)
//            return R.SUCCESS(list);
//        else
//            return R.FAIL();
//    }
}
