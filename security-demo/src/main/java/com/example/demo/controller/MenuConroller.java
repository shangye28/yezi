package com.example.demo.controller;


import com.example.demo.dao.MenuDao;
import com.example.demo.domain.MenuEntity;
import com.example.demo.domain.vo.PageVO;
import com.example.demo.result.R;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuConroller {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuService menuService;


    @GetMapping("/view")
    @PreAuthorize(value = "hasAuthority('menu:view')")
    public R<PageVO<MenuEntity>> findAll(){
        return R.SUCCESS(menuService.findAll());
    }

    @GetMapping("/treeList")
    public R<List<MenuEntity>> treeList(){
        return R.SUCCESS(menuService.treeList());
    }

    @GetMapping("/findByMenuName")
    @PreAuthorize(value = "hasAuthority('menu:list')")
    public R<PageVO<MenuEntity>> findByRoleName(@RequestBody MenuEntity menu){
        return R.SUCCESS(menuService.findByMenuName(menu.getMenuName()));
    }

    @PostMapping("/add")
    @PreAuthorize(value = "hasAuthority('menu:add')")
    public R saveMenu(@RequestBody MenuEntity menu){
        menuService.save(menu);
        return R.SUCCESS();
    }

    @PutMapping("/edit")
    @PreAuthorize(value = "hasAuthority('menu:edit')")
    public R updateMenu(@RequestBody MenuEntity menu){
        menuService.update(menu);
        return R.SUCCESS();
    }

    @DeleteMapping("/remove")
    @PreAuthorize(value = "hasAuthority('menu:remove')")
    public R deleteMenu(@RequestBody MenuEntity menu){
        menuService.delete(menu);
            return R.SUCCESS();
    }


}
