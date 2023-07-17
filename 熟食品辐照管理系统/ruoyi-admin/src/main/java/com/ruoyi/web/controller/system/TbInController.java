package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.TbGoods;
import com.ruoyi.system.domain.TbOut;
import com.ruoyi.system.domain.TbTotal;
import com.ruoyi.system.service.ITbOutService;
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
import com.ruoyi.system.domain.TbIn;
import com.ruoyi.system.service.ITbInService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/in")
public class TbInController extends BaseController
{
    private String prefix = "system/in";
    @Autowired
    private ITbOutService tbOutService;
    @Autowired
    private ITbInService tbInService;
    @Autowired
    private ITbTotalService tbTotalService;
    @RequiresPermissions("system:in:view")
    @GetMapping()
    public String in()
    {
        return prefix + "/in";
    }

    /**
     * 查询入库信息列表
     */
    @RequiresPermissions("system:in:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbIn tbIn)
    {
        startPage();
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        return getDataTable(list);
    }

    /**
     * 导出入库信息列表
     */
    @RequiresPermissions("system:in:export")
    @Log(title = "入库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbIn tbIn)
    {
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        ExcelUtil<TbIn> util = new ExcelUtil<TbIn>(TbIn.class);
        return util.exportExcel(list, "in");
    }

    /**
     * 新增入库信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存入库信息
     */
    @RequiresPermissions("system:in:add")
    @Log(title = "入库信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbIn tbIn, TbTotal tbTotal)
    {
        if(tbInService.selectTbInList(tbIn).size()==0){
            tbTotal.setInDate(new Date());
            tbTotal.setInMan(ShiroUtils.getSysUser().getUserName());
            tbTotal.setOutNum((long) 0);
            tbTotal.setTotal(tbIn.getInNum());
            tbTotalService.insertTbTotal(tbTotal);
            tbInService.insertTbIn(tbIn);
            return success("入库成功");
        }

        else {
            return error("已库成功，勿再次入库，如需添加数量，在修改出修改");
        }



    }

    /**
     * 修改入库信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbIn tbIn = tbInService.selectTbInById(id);
        mmap.put("tbIn", tbIn);
        return prefix + "/edit";
    }

    /**
     * 修改保存入库信息
     */
    @RequiresPermissions("system:in:edit")
    @Log(title = "入库信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbIn tbIn, TbTotal tbTotal, TbOut tbOut)
    {
        tbInService.updateTbIn(tbIn);
        tbTotal=tbTotalService.selectTbTotal(tbTotal);
        tbTotal.setInNum(tbIn.getInNum());
        tbTotal.setTotal(tbIn.getInNum());
        tbTotal.setTotal(tbIn.getInNum()-tbTotal.getOutNum());
        tbTotalService.updateTbTotal(tbTotal);
        return success("修改成功");
    }

    /**
     * 删除入库信息
     */
    @RequiresPermissions("system:in:remove")
    @Log(title = "入库信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbInService.deleteTbInByIds(ids));
    }
    @GetMapping("/SelectIns1")
    public String SelectIns1() {
        return prefix + "/SelectIns1";
    }
    @PostMapping("/SelectIns1")
    @ResponseBody
    public TableDataInfo Selectlist1(TbIn tbIn)
    {
        startPage();
        tbIn.setNowStatus((long) 1);
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        return getDataTable(list);
    }
    @GetMapping("/SelectIns2")
    public String SelectIns2() {
        return prefix + "/SelectIns2";
    }
    @PostMapping("/SelectIns2")
    @ResponseBody
    public TableDataInfo Selectlist2(TbIn tbIn)
    {
        startPage();
        tbIn.setNowStatus((long) 2);
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        return getDataTable(list);
    }
    @GetMapping("/SelectIns3")
    public String SelectIns3() {
        return prefix + "/SelectIns3";
    }
    @PostMapping("/SelectIns3")
    @ResponseBody
    public TableDataInfo Selectlist3(TbIn tbIn)
    {
        startPage();
        tbIn.setNowStatus((long) 3);
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        return getDataTable(list);
    }
    @GetMapping("/SelectIns4")
    public String SelectIns4() {
        return prefix + "/SelectIns4";
    }
    @PostMapping("/SelectIns4")
    @ResponseBody
    public TableDataInfo Selectlist4(TbIn tbIn)
    {
        startPage();
        tbIn.setNowStatus((long) 4);
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        return getDataTable(list);
    }
    @GetMapping("/SelectIns5")
    public String SelectIns5() {
        return prefix + "/SelectIns5";
    }
    @PostMapping("/SelectIns5")
    @ResponseBody
    public TableDataInfo Selectlist5(TbIn tbIn)
    {
        startPage();
        tbIn.setNowStatus((long) 5);
        List<TbIn> list = tbInService.selectTbInList(tbIn);
        return getDataTable(list);
    }
}
