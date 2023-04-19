package com.example.sshtest.controller;

import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.dto.PageDTO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuConroller {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuService menuService;

//    @RequestMapping("/test")
//    public R test(@RequestBody User user){
//        User user1 = userDao.getByUsername(user.getUsername());
//        if (user1 != null)
//            return R.SUCCESS(user1);
//        else
//            return R.FAIL();
//    }

    @GetMapping("/view")
    public R<PageDTO<Menu>> findAll(){
        return R.SUCCESS(menuService.findAll());
    }

}