package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.TbTotal;
import com.ruoyi.system.service.ITbTotalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/total")
public class TbTotalController extends BaseController
{
    private String prefix = "system/total";

    @Autowired
    private ITbTotalService tbTotalService;

    @RequiresPermissions("system:total:view")
    @GetMapping()
    public String total()
    {
        return prefix + "/total";
    }

    /**
     * 查询库存信息列表
     */
    @RequiresPermissions("system:total:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbTotal tbTotal)
    {
        startPage();
        List<TbTotal> list = tbTotalService.selectTbTotalList(tbTotal);
        return getDataTable(list);
    }

    /**
     * 导出库存信息列表
     */
    @RequiresPermissions("system:total:export")
    @Log(title = "库存信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbTotal tbTotal)
    {
        List<TbTotal> list = tbTotalService.selectTbTotalList(tbTotal);
        ExcelUtil<TbTotal> util = new ExcelUtil<TbTotal>(TbTotal.class);
        return util.exportExcel(list, "total");
    }

    /**
     * 新增库存信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存信息
     */
    @RequiresPermissions("system:total:add")
    @Log(title = "库存信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbTotal tbTotal)
    {
        return toAjax(tbTotalService.insertTbTotal(tbTotal));
    }

    /**
     * 修改库存信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbTotal tbTotal = tbTotalService.selectTbTotalById(id);
        mmap.put("tbTotal", tbTotal);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存信息
     */
    @RequiresPermissions("system:total:edit")
    @Log(title = "库存信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbTotal tbTotal)
    {
        return toAjax(tbTotalService.updateTbTotal(tbTotal));
    }

    /**
     * 删除库存信息
     */
    @RequiresPermissions("system:total:remove")
    @Log(title = "库存信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbTotalService.deleteTbTotalByIds(ids));
    }
}
