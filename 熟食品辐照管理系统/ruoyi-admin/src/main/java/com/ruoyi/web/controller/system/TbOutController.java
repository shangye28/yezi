package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.TbIn;
import com.ruoyi.system.domain.TbTotal;
import com.ruoyi.system.service.ITbInService;
import com.ruoyi.system.service.ITbTotalService;
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
import com.ruoyi.system.domain.TbOut;
import com.ruoyi.system.service.ITbOutService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/out")
public class TbOutController extends BaseController
{
    private String prefix = "system/out";
    @Autowired
    private ITbInService tbInService;
    @Autowired
    private ITbTotalService tbTotalService;
    @Autowired
    private ITbOutService tbOutService;

    @RequiresPermissions("system:out:view")
    @GetMapping()
    public String out()
    {
        return prefix + "/out";
    }

    /**
     * 查询出库信息列表
     */
    @RequiresPermissions("system:out:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbOut tbOut)
    {
        startPage();
        List<TbOut> list = tbOutService.selectTbOutList(tbOut);
        return getDataTable(list);
    }

    /**
     * 导出出库信息列表
     */
    @RequiresPermissions("system:out:export")
    @Log(title = "出库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbOut tbOut)
    {
        List<TbOut> list = tbOutService.selectTbOutList(tbOut);
        ExcelUtil<TbOut> util = new ExcelUtil<TbOut>(TbOut.class);
        return util.exportExcel(list, "out");
    }

    /**
     * 新增出库信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出库信息
     */
    @RequiresPermissions("system:out:add")
    @Log(title = "出库信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbOut tbOut, TbTotal tbTotal, TbIn tbIn)
    {
        tbIn=tbInService.selectTbIn(tbIn);
        tbTotal=tbTotalService.selectTbTotal(tbTotal);
        if(tbOut.getOutNum()<=tbIn.getInNum()){
            tbOutService.insertTbOut(tbOut);
            tbTotal.setTotal(tbIn.getInNum()-tbOut.getOutNum());
            tbTotal.setOutNum(tbOut.getOutNum());
            System.out.println(tbTotal.getOutNum());
            tbTotalService.updateTbTotal(tbTotal);
            tbIn.setNowStatus((long) 6);
            tbInService.updateTbIn(tbIn);
            return success();
        }else {
            return error("出库数量大于库存数量");
        }


    }

    /**
     * 修改出库信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbOut tbOut = tbOutService.selectTbOutById(id);
        mmap.put("tbOut", tbOut);
        return prefix + "/edit";
    }

    /**
     * 修改保存出库信息
     */
    @RequiresPermissions("system:out:edit")
    @Log(title = "出库信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbTotal tbTotal,TbOut tbOut)
    {
        //验证出库数量是否大于入库
        tbTotal=tbTotalService.selectTbTotal(tbTotal);
        if(tbTotal.getTotal()>=tbTotal.getOutNum()){
        tbOutService.updateTbOut(tbOut);
        tbTotal.setTotal(tbTotal.getTotal()-tbOut.getOutNum());
        tbTotalService.updateTbTotal(tbTotal);
        return success();
        }else {
            return error("库存数量不足");
        }

    }

    /**
     * 删除出库信息
     */
    @RequiresPermissions("system:out:remove")
    @Log(title = "出库信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbOutService.deleteTbOutByIds(ids));
    }
}
