package com.example.demo.controller;

import com.example.demo.dao.DeptDao;
import com.example.demo.domain.DeptEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.result.R;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DeptService deptService;

    @GetMapping("/view")
    @PreAuthorize(value = "hasAuthority('dept:view')")
    public R<PageVO<DeptEntity>> findAll(){
        return R.SUCCESS(deptService.findAll());
    }

    @GetMapping("/treeList")
    public R<List<DeptEntity>> treeList(){
        return R.SUCCESS(deptService.treeList());
    }

    @GetMapping("/findByDeptName")
    @PreAuthorize(value = "hasAuthority('dept:list')")
    public R<PageVO<DeptEntity>> findByDeptName(@RequestBody DeptEntity Dept){
        return R.SUCCESS(deptService.findByDeptName(Dept.getDeptName()));
    }

    @PostMapping("/add")
    @PreAuthorize(value = "hasAuthority('dept:add')")
    public R saveDept(@RequestBody DeptEntity dept){
        deptService.save(dept);
        return R.SUCCESS();
    }

    @PutMapping("/edit")
    @PreAuthorize(value = "hasAuthority('dept:edit')")
    public R updateDept(@RequestBody DeptEntity dept){
        deptService.update(dept);
        return R.SUCCESS();
    }

    @DeleteMapping("/remove")
    @PreAuthorize(value = "hasAuthority('dept:remove')")
    public R deleteDept(@RequestBody DeptEntity dept){
        deptService.delete(dept);
        return R.SUCCESS();
    }
}