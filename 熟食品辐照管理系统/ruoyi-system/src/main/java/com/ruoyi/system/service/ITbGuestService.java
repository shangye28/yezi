package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbGuest;

/**
 * 客户信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface ITbGuestService 
{
    /**
     * 查询客户信息
     * 
     * @param guestId 客户信息ID
     * @return 客户信息
     */
    public TbGuest selectTbGuestById(Long guestId);

    /**
     * 查询客户信息列表
     * 
     * @param tbGuest 客户信息
     * @return 客户信息集合
     */
    public List<TbGuest> selectTbGuestList(TbGuest tbGuest);

    /**
     * 新增客户信息
     * 
     * @param tbGuest 客户信息
     * @return 结果
     */
    public int insertTbGuest(TbGuest tbGuest);

    /**
     * 修改客户信息
     * 
     * @param tbGuest 客户信息
     * @return 结果
     */
    public int updateTbGuest(TbGuest tbGuest);

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbGuestByIds(String ids);

    /**
     * 删除客户信息信息
     * 
     * @param guestId 客户信息ID
     * @return 结果
     */
    public int deleteTbGuestById(Long guestId);
}
