package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbCraftMapper;
import com.ruoyi.system.domain.TbCraft;
import com.ruoyi.system.service.ITbCraftService;
import com.ruoyi.common.core.text.Convert;

/**
 * 辐射工艺处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbCraftServiceImpl implements ITbCraftService 
{
    @Autowired
    private TbCraftMapper tbCraftMapper;

    /**
     * 查询辐射工艺处理
     * 
     * @param id 辐射工艺处理ID
     * @return 辐射工艺处理
     */
    @Override
    public TbCraft selectTbCraftById(Long id)
    {
        return tbCraftMapper.selectTbCraftById(id);
    }

    /**
     * 查询辐射工艺处理列表
     * 
     * @param tbCraft 辐射工艺处理
     * @return 辐射工艺处理
     */
    @Override
    public List<TbCraft> selectTbCraftList(TbCraft tbCraft)
    {
        return tbCraftMapper.selectTbCraftList(tbCraft);
    }

    /**
     * 新增辐射工艺处理
     * 
     * @param tbCraft 辐射工艺处理
     * @return 结果
     */
    @Override
    public int insertTbCraft(TbCraft tbCraft)
    {
        return tbCraftMapper.insertTbCraft(tbCraft);
    }

    /**
     * 修改辐射工艺处理
     * 
     * @param tbCraft 辐射工艺处理
     * @return 结果
     */
    @Override
    public int updateTbCraft(TbCraft tbCraft)
    {
        return tbCraftMapper.updateTbCraft(tbCraft);
    }

    /**
     * 删除辐射工艺处理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbCraftByIds(String ids)
    {
        return tbCraftMapper.deleteTbCraftByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除辐射工艺处理信息
     * 
     * @param id 辐射工艺处理ID
     * @return 结果
     */
    @Override
    public int deleteTbCraftById(Long id)
    {
        return tbCraftMapper.deleteTbCraftById(id);
    }
}
