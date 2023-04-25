package com.example.sshtest.controller;


import com.example.sshtest.dao.RoleDao;
import com.example.sshtest.pojo.Role;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleService roleService;

//    @RequestMapping("/test")
//    public R test(@RequestBody Role role){
//        Role user1 = roleService);
//        if (user1 != null)
//            return R.SUCCESS(user1);
//        else
//            return R.FAIL();
//    }

    @GetMapping("/view")
    public R<PageVO<Role>> findAll(){
        return R.SUCCESS(roleService.findAll());
    }

    @GetMapping("/findByRoleName")
    public R<PageVO<Role>> findByRoleName(@RequestBody Role role){
        return R.SUCCESS(roleService.findByRoleName(role.getRoleName()));
    }

    @DeleteMapping("/delete")
    public R deleteRole(@RequestBody Role role){
        if(roleService.delete(role.getRoleId()))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PostMapping("/save")
    public R saveRole(@RequestBody Role role){
        if(roleService.save(role))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PutMapping("/update")
    public R updateRole(@RequestBody Role role){
        if(roleService.update(role))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

}
