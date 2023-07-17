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
import com.ruoyi.system.domain.TbGoods;
import com.ruoyi.system.service.ITbGoodsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Controller
@RequestMapping("/system/goods")
public class TbGoodsController extends BaseController
{
    private String prefix = "system/goods";

    @Autowired
    private ITbGoodsService tbGoodsService;

    @RequiresPermissions("system:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询产品信息列表
     */
    @RequiresPermissions("system:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbGoods tbGoods)
    {
        startPage();
        List<TbGoods> list = tbGoodsService.selectTbGoodsList(tbGoods);
        return getDataTable(list);
    }

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("system:goods:export")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbGoods tbGoods)
    {
        List<TbGoods> list = tbGoodsService.selectTbGoodsList(tbGoods);
        ExcelUtil<TbGoods> util = new ExcelUtil<TbGoods>(TbGoods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 新增产品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("system:goods:add")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbGoods tbGoods)
    {   TbGoods tbGoodsnew=new TbGoods();
        tbGoodsnew.setGoodsDime(null);
        tbGoodsnew.setGoodsNo(null);
        tbGoodsnew.setGoodsName(null);
        tbGoodsnew.setRadiNo(tbGoods.getRadiNo());
        List<TbGoods> tbGoods1=tbGoodsService.selectTbGoodsList(tbGoodsnew);
        tbGoodsnew.setRadiNo(null);
        tbGoodsnew.setGoodsName(tbGoods.getGoodsName());
        List<TbGoods> tbGoods2=tbGoodsService.selectTbGoodsList(tbGoodsnew);
        if(tbGoods1.size()!=0){

            return error("辐照批号已经存在");
        }
        else if(tbGoods2.size()!=0){
            return error("产品名称已经存在");
        }
        else {
            tbGoodsService.insertTbGoods(tbGoods);
            return success();
        }
    }

    /**
     * 修改产品信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbGoods tbGoods = tbGoodsService.selectTbGoodsById(id);
        mmap.put("tbGoods", tbGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("system:goods:edit")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbGoods tbGoods)
    {
        TbGoods tbGoodsnew=new TbGoods();
        tbGoodsnew.setGoodsDime(null);
        tbGoodsnew.setGoodsNo(null);
        tbGoodsnew.setGoodsName(null);
        tbGoodsnew.setRadiNo(tbGoods.getRadiNo());
        List<TbGoods> tbGoods1=tbGoodsService.selectTbGoodsList(tbGoodsnew);
        tbGoodsnew.setRadiNo(null);
        tbGoodsnew.setGoodsName(tbGoods.getGoodsName());
        List<TbGoods> tbGoods2=tbGoodsService.selectTbGoodsList(tbGoodsnew);
        if(tbGoods1.size()!=0){
            return error("辐照批号已经存在");
        }
        else if(tbGoods2.size()!=0){
            return error("产品名称已经存在");
        }
        else {
            tbGoodsService.updateTbGoods(tbGoods);
            return success();
        }
    }

    /**
     * 删除产品信息
     */
    @RequiresPermissions("system:goods:remove")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbGoodsService.deleteTbGoodsByIds(ids));
    }
    @GetMapping("/SelectGoods")
    public String SelectGoods() {
        return prefix + "/SelectGoods";
    }
    @PostMapping("/SelectGoods")
    @ResponseBody
    public TableDataInfo SelectGoods(TbGoods tbGoods)
    {
        startPage();
        List<TbGoods> list = tbGoodsService.selectTbGoodsList(tbGoods);
        return getDataTable(list);
    }
}
