package com.example.demo.controller;

import com.example.demo.dao.RoleDao;
import com.example.demo.domain.RoleEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.result.R;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleService roleService;

    @GetMapping("/view")
    @PreAuthorize(value = "hasAuthority('role:view')")
    public R<PageVO<RoleEntity>> findAll(){
        return R.SUCCESS(roleService.findAll());
    }

    @GetMapping("/findByRoleName")
    @PreAuthorize(value = "hasAuthority('role:list')")
    public R<PageVO<RoleEntity>> findByRoleName(String roleName){
        return R.SUCCESS(roleService.findByRoleName(roleName));
    }

    @PostMapping("/add")
    @PreAuthorize(value = "hasAuthority('role:add')")
    public R saveRole(@RequestBody RoleEntity role){
        roleService.save(role);
        return R.SUCCESS();
    }

    @PutMapping("/edit")
    @PreAuthorize(value = "hasAuthority('role:edit')")
    public R updateRole(@RequestBody RoleEntity role){
        roleService.update(role);
        return R.SUCCESS();
    }

    @DeleteMapping("/remove")
    @PreAuthorize(value = "hasAuthority('role:remove')")
    public R deleteRole(@RequestBody RoleEntity role){
        roleService.delete(role);
            return R.SUCCESS();
    }
}
