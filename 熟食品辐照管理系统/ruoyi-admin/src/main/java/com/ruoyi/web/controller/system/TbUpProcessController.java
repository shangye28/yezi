package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.TbIn;
import com.ruoyi.system.service.ITbInService;
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
import com.ruoyi.system.domain.TbUpProcess;
import com.ruoyi.system.service.ITbUpProcessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 上货处理Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/upprocess")
public class TbUpProcessController extends BaseController
{
    private String prefix = "system/upprocess";
    @Autowired
    private ITbInService tbInService;
    @Autowired
    private ITbUpProcessService tbUpProcessService;

    @RequiresPermissions("system:upprocess:view")
    @GetMapping()
    public String upprocess()
    {
        return prefix + "/upprocess";
    }

    /**
     * 查询上货处理列表
     */
    @RequiresPermissions("system:upprocess:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbUpProcess tbUpProcess)
    {
        startPage();
        List<TbUpProcess> list = tbUpProcessService.selectTbUpProcessList(tbUpProcess);
        return getDataTable(list);
    }

    /**
     * 导出上货处理列表
     */
    @RequiresPermissions("system:upprocess:export")
    @Log(title = "上货处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbUpProcess tbUpProcess)
    {
        List<TbUpProcess> list = tbUpProcessService.selectTbUpProcessList(tbUpProcess);
        ExcelUtil<TbUpProcess> util = new ExcelUtil<TbUpProcess>(TbUpProcess.class);
        return util.exportExcel(list, "upprocess");
    }

    /**
     * 新增上货处理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存上货处理
     */
    @RequiresPermissions("system:upprocess:add")
    @Log(title = "上货处理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbUpProcess tbUpProcess, TbIn tbIn)
    {
        tbUpProcessService.insertTbUpProcess(tbUpProcess);
        tbIn=tbInService.selectTbIn(tbIn);
        tbIn.setNowStatus((long) 3);
        tbInService.updateTbIn(tbIn);
        return success();
    }

    /**
     * 修改上货处理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbUpProcess tbUpProcess = tbUpProcessService.selectTbUpProcessById(id);
        mmap.put("tbUpProcess", tbUpProcess);
        return prefix + "/edit";
    }

    /**
     * 修改保存上货处理
     */
    @RequiresPermissions("system:upprocess:edit")
    @Log(title = "上货处理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbUpProcess tbUpProcess)
    {
        return toAjax(tbUpProcessService.updateTbUpProcess(tbUpProcess));
    }

    /**
     * 删除上货处理
     */
    @RequiresPermissions("system:upprocess:remove")
    @Log(title = "上货处理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbUpProcessService.deleteTbUpProcessByIds(ids));
    }
}
