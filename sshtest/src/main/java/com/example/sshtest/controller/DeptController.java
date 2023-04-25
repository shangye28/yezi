package com.example.sshtest.controller;

import com.example.sshtest.dao.DeptDao;
import com.example.sshtest.pojo.Dept;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DeptService deptService;

    @GetMapping("/view")
    public R<PageVO<Dept>> findAll(){
        return R.SUCCESS(deptService.findAll());
    }

    @GetMapping("/findByMenuName")
    public R<PageVO<Dept>> findByDeptName(@RequestBody Dept Dept){
        return R.SUCCESS(deptService.findByDeptName(Dept.getDeptName()));
    }

    @DeleteMapping("/delete")
    public R deleteDept(@RequestBody Dept dept){
        if(deptService.delete(dept.getDeptId()))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PostMapping("/save")
    public R saveDept(@RequestBody Dept dept){
        if(deptService.save(dept))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PutMapping("/update")
    public R updateDept(@RequestBody Dept dept){
        if(deptService.update(dept))
            return R.SUCCESS();
        else
            return R.FAIL();
    }
}
