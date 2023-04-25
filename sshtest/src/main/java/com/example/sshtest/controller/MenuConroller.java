package com.example.sshtest.controller;

import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import com.example.sshtest.pojo.vo.PageVO;
import com.example.sshtest.result.R;
import com.example.sshtest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuConroller {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuService menuService;


    @GetMapping("/view")
    public R<PageVO<Menu>> findAll(){
        return R.SUCCESS(menuService.findAll());
    }

    @GetMapping("/findByMenuName")
    public R<PageVO<Menu>> findByRoleName(@RequestBody Menu menu){
        return R.SUCCESS(menuService.findByMenuName(menu.getMenuName()));
    }

    @DeleteMapping("/delete")
    public R deleteMenu(@RequestBody Menu menu){
        if(menuService.delete(menu.getMenuId()))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PostMapping("/save")
    public R saveMenu(@RequestBody Menu menu){
        if(menuService.save(menu))
            return R.SUCCESS();
        else
            return R.FAIL();
    }

    @PutMapping("/update")
    public R updateMenu(@RequestBody Menu menu){
        if(menuService.update(menu))
            return R.SUCCESS();
        else
            return R.FAIL();
    }
}
