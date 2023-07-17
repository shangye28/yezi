package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 tb_guest
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public class TbGuest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long guestId;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String guestNumber;

    /** 客户名 */
    @Excel(name = "客户名")
    private String guestName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String tel;

    public void setGuestId(Long guestId) 
    {
        this.guestId = guestId;
    }

    public Long getGuestId() 
    {
        return guestId;
    }
    public void setGuestNumber(String guestNumber) 
    {
        this.guestNumber = guestNumber;
    }

    public String getGuestNumber() 
    {
        return guestNumber;
    }
    public void setGuestName(String guestName) 
    {
        this.guestName = guestName;
    }

    public String getGuestName() 
    {
        return guestName;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("guestId", getGuestId())
            .append("guestNumber", getGuestNumber())
            .append("guestName", getGuestName())
            .append("contact", getContact())
            .append("tel", getTel())
            .toString();
    }
}
