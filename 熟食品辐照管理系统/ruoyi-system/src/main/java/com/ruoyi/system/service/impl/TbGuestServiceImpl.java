package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbGuestMapper;
import com.ruoyi.system.domain.TbGuest;
import com.ruoyi.system.service.ITbGuestService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbGuestServiceImpl implements ITbGuestService 
{
    @Autowired
    private TbGuestMapper tbGuestMapper;

    /**
     * 查询客户信息
     * 
     * @param guestId 客户信息ID
     * @return 客户信息
     */
    @Override
    public TbGuest selectTbGuestById(Long guestId)
    {
        return tbGuestMapper.selectTbGuestById(guestId);
    }

    /**
     * 查询客户信息列表
     * 
     * @param tbGuest 客户信息
     * @return 客户信息
     */
    @Override
    public List<TbGuest> selectTbGuestList(TbGuest tbGuest)
    {
        return tbGuestMapper.selectTbGuestList(tbGuest);
    }

    /**
     * 新增客户信息
     * 
     * @param tbGuest 客户信息
     * @return 结果
     */
    @Override
    public int insertTbGuest(TbGuest tbGuest)
    {
        return tbGuestMapper.insertTbGuest(tbGuest);
    }

    /**
     * 修改客户信息
     * 
     * @param tbGuest 客户信息
     * @return 结果
     */
    @Override
    public int updateTbGuest(TbGuest tbGuest)
    {
        return tbGuestMapper.updateTbGuest(tbGuest);
    }

    /**
     * 删除客户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbGuestByIds(String ids)
    {
        return tbGuestMapper.deleteTbGuestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户信息信息
     * 
     * @param guestId 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteTbGuestById(Long guestId)
    {
        return tbGuestMapper.deleteTbGuestById(guestId);
    }
}
