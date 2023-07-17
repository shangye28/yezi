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
import com.ruoyi.system.domain.TbDownProcess;
import com.ruoyi.system.service.ITbDownProcessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 卸货处理Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/tdprocess")
public class TbDownProcessController extends BaseController
{
    private String prefix = "system/tdprocess";
    @Autowired
    private ITbInService tbInService;
    @Autowired
    private ITbDownProcessService tbDownProcessService;

    @RequiresPermissions("system:tdprocess:view")
    @GetMapping()
    public String tdprocess()
    {
        return prefix + "/tdprocess";
    }

    /**
     * 查询卸货处理列表
     */
    @RequiresPermissions("system:tdprocess:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbDownProcess tbDownProcess)
    {
        startPage();
        List<TbDownProcess> list = tbDownProcessService.selectTbDownProcessList(tbDownProcess);
        return getDataTable(list);
    }

    /**
     * 导出卸货处理列表
     */
    @RequiresPermissions("system:tdprocess:export")
    @Log(title = "卸货处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbDownProcess tbDownProcess)
    {
        List<TbDownProcess> list = tbDownProcessService.selectTbDownProcessList(tbDownProcess);
        ExcelUtil<TbDownProcess> util = new ExcelUtil<TbDownProcess>(TbDownProcess.class);
        return util.exportExcel(list, "tdprocess");
    }

    /**
     * 新增卸货处理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存卸货处理
     */
    @RequiresPermissions("system:tdprocess:add")
    @Log(title = "卸货处理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbDownProcess tbDownProcess, TbIn tbIn)
    { tbDownProcessService.insertTbDownProcess(tbDownProcess);
        tbIn=tbInService.selectTbIn(tbIn);
        tbIn.setNowStatus((long) 5);
        tbInService.updateTbIn(tbIn);
        return success();
    }

    /**
     * 修改卸货处理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbDownProcess tbDownProcess = tbDownProcessService.selectTbDownProcessById(id);
        mmap.put("tbDownProcess", tbDownProcess);
        return prefix + "/edit";
    }

    /**
     * 修改保存卸货处理
     */
    @RequiresPermissions("system:tdprocess:edit")
    @Log(title = "卸货处理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbDownProcess tbDownProcess)
    {
        return toAjax(tbDownProcessService.updateTbDownProcess(tbDownProcess));
    }

    /**
     * 删除卸货处理
     */
    @RequiresPermissions("system:tdprocess:remove")
    @Log(title = "卸货处理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbDownProcessService.deleteTbDownProcessByIds(ids));
    }
}
