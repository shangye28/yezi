package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 卸货处理对象 tb_down_process
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class TbDownProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 辐射批号 */
    @Excel(name = "辐射批号")
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

    /** 摆放区域 */
    @Excel(name = "摆放区域")
    private String area;

    /** 卸货人 */
    @Excel(name = "卸货人")
    private String downMan;

    /** 卸货开始日期 */
    @Excel(name = "卸货开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 卸货结束日期 */
    @Excel(name = "卸货结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 备注1 */
    @Excel(name = "备注1")
    private String note1;

    /** 备注2 */
    @Excel(name = "备注2")
    private String note2;

    /** 备注3 */
    @Excel(name = "备注3")
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
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setDownMan(String downMan) 
    {
        this.downMan = downMan;
    }

    public String getDownMan() 
    {
        return downMan;
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
            .append("area", getArea())
            .append("downMan", getDownMan())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("note1", getNote1())
            .append("note2", getNote2())
            .append("note3", getNote3())
            .toString();
    }
}
