package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.TbIn;
import com.ruoyi.system.domain.TbTotal;
import com.ruoyi.system.service.ITbInService;
import io.swagger.models.auth.In;
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
import com.ruoyi.system.domain.TbCraft;
import com.ruoyi.system.service.ITbCraftService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 辐射工艺处理Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/craft")
public class TbCraftController extends BaseController
{
    private String prefix = "system/craft";
    @Autowired
    private ITbInService tbInService;
    @Autowired
    private ITbCraftService tbCraftService;

    @RequiresPermissions("system:craft:view")
    @GetMapping()
    public String craft()
    {
        return prefix + "/craft";
    }

    /**
     * 查询辐射工艺处理列表
     */
    @RequiresPermissions("system:craft:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbCraft tbCraft)
    {
        startPage();
        List<TbCraft> list = tbCraftService.selectTbCraftList(tbCraft);
        return getDataTable(list);
    }

    /**
     * 导出辐射工艺处理列表
     */
    @RequiresPermissions("system:craft:export")
    @Log(title = "辐射工艺处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbCraft tbCraft)
    {
        List<TbCraft> list = tbCraftService.selectTbCraftList(tbCraft);
        ExcelUtil<TbCraft> util = new ExcelUtil<TbCraft>(TbCraft.class);
        return util.exportExcel(list, "craft");
    }

    /**
     * 新增辐射工艺处理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存辐射工艺处理
     */
    @RequiresPermissions("system:craft:add")
    @Log(title = "辐射工艺处理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbCraft tbCraft, TbIn tbIn)
    {
        tbCraftService.insertTbCraft(tbCraft);
        tbIn=tbInService.selectTbIn(tbIn);
        tbIn.setNowStatus((long) 2);
        tbInService.updateTbIn(tbIn);
        return success();
    }

    /**
     * 修改辐射工艺处理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbCraft tbCraft = tbCraftService.selectTbCraftById(id);
        mmap.put("tbCraft", tbCraft);
        return prefix + "/edit";
    }

    /**
     * 修改保存辐射工艺处理
     */
    @RequiresPermissions("system:craft:edit")
    @Log(title = "辐射工艺处理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbCraft tbCraft)
    {
        return toAjax(tbCraftService.updateTbCraft(tbCraft));
    }

    /**
     * 删除辐射工艺处理
     */
    @RequiresPermissions("system:craft:remove")
    @Log(title = "辐射工艺处理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbCraftService.deleteTbCraftByIds(ids));
    }
}
