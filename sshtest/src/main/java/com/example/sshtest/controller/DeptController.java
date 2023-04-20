package com.example.sshtest.controller;

import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DeptService deptService;

//    @RequestMapping("/test")
//    public R test(@RequestBody User user){
//        User user1 = userDao.getByUsername(user.getUsername());
//        if (user1 != null)
//            return R.SUCCESS(user1);
//        else
//            return R.FAIL();
//    }

    @GetMapping("/view")
    public R<PageVO<Dept>> findAll(){
        return R.SUCCESS(deptService.findAll());
    }
}
