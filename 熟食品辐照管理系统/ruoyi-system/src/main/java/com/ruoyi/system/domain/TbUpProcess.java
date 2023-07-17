package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 上货处理对象 tb_up_process
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class TbUpProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 辐照批号 */
    @Excel(name = "辐照批号")
    private String radiNo;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String goodsName;

    /** 产品批号 */
    @Excel(name = "产品批号")
    private String goodsNo;

    /** 产品规格 */
    @Excel(name = "产品规格")
    private String goodsDime;

    /** 货箱号 */
    @Excel(name = "货箱号")
    private String boxNo;

    /** 装货数量 */
    @Excel(name = "装货数量")
    private Long goodsNumber;

    /** 装货人 */
    @Excel(name = "装货人")
    private String loadMan;

    /** 开始装货日期 */
    @Excel(name = "开始装货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束装货日期 */
    @Excel(name = "结束装货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 备注1 */
    @Excel(name = "备注1")
    private String note1;

    /** 备注2 */
    @Excel(name = "备注2")
    private String note2;

    /** 备注1 */
    @Excel(name = "备注1")
    private String note3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRadiNo(String radiNo) 
    {
        this.radiNo = radiNo;
    }

    public String getRadiNo() 
    {
        return radiNo;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setGoodsNo(String goodsNo) 
    {
        this.goodsNo = goodsNo;
    }

    public String getGoodsNo() 
    {
        return goodsNo;
    }
    public void setGoodsDime(String goodsDime) 
    {
        this.goodsDime = goodsDime;
    }

    public String getGoodsDime() 
    {
        return goodsDime;
    }
    public void setBoxNo(String boxNo) 
    {
        this.boxNo = boxNo;
    }

    public String getBoxNo() 
    {
        return boxNo;
    }
    public void setGoodsNumber(Long goodsNumber) 
    {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsNumber() 
    {
        return goodsNumber;
    }
    public void setLoadMan(String loadMan) 
    {
        this.loadMan = loadMan;
    }

    public String getLoadMan() 
    {
        return loadMan;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setNote1(String note1) 
    {
        this.note1 = note1;
    }

    public String getNote1() 
    {
        return note1;
    }
    public void setNote2(String note2) 
    {
        this.note2 = note2;
    }

    public String getNote2() 
    {
        return note2;
    }
    public void setNote3(String note3) 
    {
        this.note3 = note3;
    }

    public String getNote3() 
    {
        return note3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("radiNo", getRadiNo())
            .append("goodsName", getGoodsName())
            .append("goodsNo", getGoodsNo())
            .append("goodsDime", getGoodsDime())
            .append("boxNo", getBoxNo())
            .append("goodsNumber", getGoodsNumber())
            .append("loadMan", getLoadMan())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("note1", getNote1())
            .append("note2", getNote2())
            .append("note3", getNote3())
            .toString();
    }
}
