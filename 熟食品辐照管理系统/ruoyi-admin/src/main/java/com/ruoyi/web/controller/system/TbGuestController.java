package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.TbGoods;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TbGuest;
import com.ruoyi.system.service.ITbGuestService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/guest")
public class TbGuestController extends BaseController
{
    private String prefix = "system/guest";

    @Autowired
    private ITbGuestService tbGuestService;

    @RequiresPermissions("system:guest:view")
    @GetMapping()
    public String guest()
    {
        return prefix + "/guest";
    }

    /**
     * 查询客户信息列表
     */
    @RequiresPermissions("system:guest:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbGuest tbGuest)
    {
        startPage();
        List<TbGuest> list = tbGuestService.selectTbGuestList(tbGuest);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @RequiresPermissions("system:guest:export")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbGuest tbGuest)
    {
        List<TbGuest> list = tbGuestService.selectTbGuestList(tbGuest);
        ExcelUtil<TbGuest> util = new ExcelUtil<TbGuest>(TbGuest.class);
        return util.exportExcel(list, "guest");
    }

    /**
     * 新增客户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户信息
     */
    @RequiresPermissions("system:guest:add")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbGuest tbGuest)
    {
        TbGuest tbGoodsnew=new TbGuest();
        tbGoodsnew.setContact(null);
        tbGoodsnew.setTel(null);
        tbGoodsnew.setGuestName(null);
        tbGoodsnew.setGuestNumber(tbGuest.getGuestNumber());
        List<TbGuest> tbGoods1=tbGuestService.selectTbGuestList(tbGoodsnew);
        tbGoodsnew.setGuestNumber(null);
        tbGoodsnew.setGuestName(tbGuest.getGuestName());
        List<TbGuest> tbGoods2=tbGuestService.selectTbGuestList(tbGoodsnew);
        if(tbGoods1.size()!=0){

            return error("客户编号已经存在");
        }
        else if(tbGoods2.size()!=0){
            return error("客户名已经存在");
        }
        else {
            tbGuestService.insertTbGuest(tbGuest);
            return success();
        }
    }

    /**
     * 修改客户信息
     */
    @GetMapping("/edit/{guestId}")
    public String edit(@PathVariable("guestId") Long guestId, ModelMap mmap)
    {
        TbGuest tbGuest = tbGuestService.selectTbGuestById(guestId);
        mmap.put("tbGuest", tbGuest);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户信息
     */
    @RequiresPermissions("system:guest:edit")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbGuest tbGuest)
    {
        TbGuest tbGoodsnew=new TbGuest();
        tbGoodsnew.setContact(null);
        tbGoodsnew.setTel(null);
        tbGoodsnew.setGuestName(null);
        tbGoodsnew.setGuestNumber(tbGuest.getGuestNumber());
        List<TbGuest> tbGoods1=tbGuestService.selectTbGuestList(tbGoodsnew);
        tbGoodsnew.setGuestNumber(null);
        tbGoodsnew.setGuestName(tbGuest.getGuestName());
        List<TbGuest> tbGoods2=tbGuestService.selectTbGuestList(tbGoodsnew);
        if(tbGoods1.size()!=0){

            return error("客户编号已经存在");
        }
        else if(tbGoods2.size()!=0){
            return error("客户名已经存在");
        }
        else {
            tbGuestService.updateTbGuest(tbGuest);
            return success();
        }
    }

    /**
     * 删除客户信息
     */
    @RequiresPermissions("system:guest:remove")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbGuestService.deleteTbGuestByIds(ids));
    }
    @GetMapping("/SelectGuests")
    public String SelectGuests() {
        return prefix + "/SelectGuests";
    }
}
