package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品信息对象 tb_goods
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class TbGoods extends BaseEntity
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("radiNo", getRadiNo())
            .append("goodsName", getGoodsName())
            .append("goodsNo", getGoodsNo())
            .append("goodsDime", getGoodsDime())
            .toString();
    }
}
