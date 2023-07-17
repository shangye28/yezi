package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 辐射工艺处理对象 tb_craft
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class TbCraft extends BaseEntity
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

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String guestName;

    /** 安排时间 */
    @Excel(name = "安排时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrangDate;

    /** 工艺说明 */
    @Excel(name = "工艺说明")
    private String procDesc;

    /** 制定人 */
    @Excel(name = "制定人")
    private String makeMan;

    /** 审核人 */
    @Excel(name = "审核人")
    private String examMan;

    /** 设计工艺日期 */
    @Excel(name = "设计工艺日期")
    private String makeDate;

    /** 开始辐照日期 */
    @Excel(name = "开始辐照日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束辐照日期 */
    @Excel(name = "结束辐照日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

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
    public void setGuestName(String guestName) 
    {
        this.guestName = guestName;
    }

    public String getGuestName() 
    {
        return guestName;
    }
    public void setArrangDate(Date arrangDate) 
    {
        this.arrangDate = arrangDate;
    }

    public Date getArrangDate() 
    {
        return arrangDate;
    }
    public void setProcDesc(String procDesc) 
    {
        this.procDesc = procDesc;
    }

    public String getProcDesc() 
    {
        return procDesc;
    }
    public void setMakeMan(String makeMan) 
    {
        this.makeMan = makeMan;
    }

    public String getMakeMan() 
    {
        return makeMan;
    }
    public void setExamMan(String examMan) 
    {
        this.examMan = examMan;
    }

    public String getExamMan() 
    {
        return examMan;
    }
    public void setMakeDate(String makeDate) 
    {
        this.makeDate = makeDate;
    }

    public String getMakeDate() 
    {
        return makeDate;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
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
            .append("guestName", getGuestName())
            .append("arrangDate", getArrangDate())
            .append("procDesc", getProcDesc())
            .append("makeMan", getMakeMan())
            .append("examMan", getExamMan())
            .append("makeDate", getMakeDate())
            .append("startDate", getStartDate())
            .append("endTime", getEndTime())
            .append("note1", getNote1())
            .append("note2", getNote2())
            .append("note3", getNote3())
            .toString();
    }
}
