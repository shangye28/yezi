package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入库信息对象 tb_in
 *
 * @author ruoyi
 * @date 2020-09-08
 */
public class TbIn extends BaseEntity
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

    /** 单重 */
    @Excel(name = "单重")
    private Long singleWeight;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long inNum;

    /** 送货人 */
    @Excel(name = "送货人")
    private String sendMan;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    /** 要求交换时间 */
    @Excel(name = "要求交换时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliDate;

    /** 结账方式 */
    @Excel(name = "结账方式")
    private String payModel;

    /** 客户要求 */
    @Excel(name = "客户要求")
    private String custRequire;

    /** 收货人 */
    @Excel(name = "收货人")
    private String receiveMan;

    /** 单价 */
    @Excel(name = "单价")
    private Long price;

    /** 备注1 */
    @Excel(name = "备注1")
    private String note1;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private Long nowStatus;

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
    public void setSendMan(String sendMan)
    {
        this.sendMan = sendMan;
    }

    public String getSendMan()
    {
        return sendMan;
    }
    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber()
    {
        return carNumber;
    }
    public void setDeliDate(Date deliDate)
    {
        this.deliDate = deliDate;
    }

    public Date getDeliDate()
    {
        return deliDate;
    }
    public void setPayModel(String payModel)
    {
        this.payModel = payModel;
    }

    public String getPayModel()
    {
        return payModel;
    }
    public void setCustRequire(String custRequire)
    {
        this.custRequire = custRequire;
    }

    public String getCustRequire()
    {
        return custRequire;
    }
    public void setReceiveMan(String receiveMan)
    {
        this.receiveMan = receiveMan;
    }

    public String getReceiveMan()
    {
        return receiveMan;
    }
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setNote1(String note1)
    {
        this.note1 = note1;
    }

    public String getNote1()
    {
        return note1;
    }
    public void setNowStatus(Long nowStatus)
    {
        this.nowStatus = nowStatus;
    }

    public Long getNowStatus()
    {
        return nowStatus;
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
                .append("sendMan", getSendMan())
                .append("carNumber", getCarNumber())
                .append("deliDate", getDeliDate())
                .append("payModel", getPayModel())
                .append("custRequire", getCustRequire())
                .append("receiveMan", getReceiveMan())
                .append("price", getPrice())
                .append("note1", getNote1())
                .append("nowStatus", getNowStatus())
                .append("note2", getNote2())
                .append("note3", getNote3())
                .toString();
    }
}