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
import com.ruoyi.system.domain.TbTurnProcess;
import com.ruoyi.system.service.ITbTurnProcessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 换成处理Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/tuprocess")
public class TbTurnProcessController extends BaseController
{
    private String prefix = "system/tuprocess";
    @Autowired
    private ITbInService tbInService;
    @Autowired
    private ITbTurnProcessService tbTurnProcessService;

    @RequiresPermissions("system:tuprocess:view")
    @GetMapping()
    public String tuprocess()
    {
        return prefix + "/tuprocess";
    }

    /**
     * 查询换成处理列表
     */
    @RequiresPermissions("system:tuprocess:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbTurnProcess tbTurnProcess)
    {
        startPage();
        List<TbTurnProcess> list = tbTurnProcessService.selectTbTurnProcessList(tbTurnProcess);
        return getDataTable(list);
    }

    /**
     * 导出换成处理列表
     */
    @RequiresPermissions("system:tuprocess:export")
    @Log(title = "换成处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbTurnProcess tbTurnProcess)
    {
        List<TbTurnProcess> list = tbTurnProcessService.selectTbTurnProcessList(tbTurnProcess);
        ExcelUtil<TbTurnProcess> util = new ExcelUtil<TbTurnProcess>(TbTurnProcess.class);
        return util.exportExcel(list, "tuprocess");
    }

    /**
     * 新增换成处理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存换成处理
     */
    @RequiresPermissions("system:tuprocess:add")
    @Log(title = "换成处理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbTurnProcess tbTurnProcess, TbIn tbIn)
    {
        tbTurnProcessService.insertTbTurnProcess(tbTurnProcess);
        tbIn=tbInService.selectTbIn(tbIn);
        tbIn.setNowStatus((long) 4);
        tbInService.updateTbIn(tbIn);
        return success();
    }

    /**
     * 修改换成处理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbTurnProcess tbTurnProcess = tbTurnProcessService.selectTbTurnProcessById(id);
        mmap.put("tbTurnProcess", tbTurnProcess);
        return prefix + "/edit";
    }

    /**
     * 修改保存换成处理
     */
    @RequiresPermissions("system:tuprocess:edit")
    @Log(title = "换成处理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbTurnProcess tbTurnProcess)
    {
        return toAjax(tbTurnProcessService.updateTbTurnProcess(tbTurnProcess));
    }

    /**
     * 删除换成处理
     */
    @RequiresPermissions("system:tuprocess:remove")
    @Log(title = "换成处理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbTurnProcessService.deleteTbTurnProcessByIds(ids));
    }
}
