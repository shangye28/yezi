package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存信息对象 tb_total
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class TbTotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 辐照编号 */
    @Excel(name = "辐照编号")
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

    /** 单重 */
    @Excel(name = "单重")
    private Long singleWeight;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long inNum;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private Long outNum;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long total;

    /** 入库日期 */
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inDate;

    /** 出库日期 */
    @Excel(name = "出库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outDate;

    /** 入库人 */
    @Excel(name = "入库人")
    private String inMan;

    /** 发货人 */
    @Excel(name = "发货人")
    private String outMan;

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
    public void setSingleWeight(Long singleWeight) 
    {
        this.singleWeight = singleWeight;
    }

    public Long getSingleWeight() 
    {
        return singleWeight;
    }
    public void setInNum(Long inNum) 
    {
        this.inNum = inNum;
    }

    public Long getInNum() 
    {
        return inNum;
    }
    public void setOutNum(Long outNum) 
    {
        this.outNum = outNum;
    }

    public Long getOutNum() 
    {
        return outNum;
    }
    public void setTotal(Long total) 
    {
        this.total = total;
    }

    public Long getTotal() 
    {
        return total;
    }
    public void setInDate(Date inDate) 
    {
        this.inDate = inDate;
    }

    public Date getInDate() 
    {
        return inDate;
    }
    public void setOutDate(Date outDate) 
    {
        this.outDate = outDate;
    }

    public Date getOutDate() 
    {
        return outDate;
    }
    public void setInMan(String inMan) 
    {
        this.inMan = inMan;
    }

    public String getInMan() 
    {
        return inMan;
    }
    public void setOutMan(String outMan) 
    {
        this.outMan = outMan;
    }

    public String getOutMan() 
    {
        return outMan;
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
            .append("singleWeight", getSingleWeight())
            .append("inNum", getInNum())
            .append("outNum", getOutNum())
            .append("total", getTotal())
            .append("inDate", getInDate())
            .append("outDate", getOutDate())
            .append("inMan", getInMan())
            .append("outMan", getOutMan())
            .append("note1", getNote1())
            .append("note2", getNote2())
            .append("note3", getNote3())
            .toString();
    }
}
