package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbInMapper;
import com.ruoyi.system.domain.TbIn;
import com.ruoyi.system.service.ITbInService;
import com.ruoyi.common.core.text.Convert;

/**
 * 入库信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbInServiceImpl implements ITbInService 
{
    @Autowired
    private TbInMapper tbInMapper;

    /**
     * 查询入库信息
     * 
     * @param id 入库信息ID
     * @return 入库信息
     */
    @Override
    public TbIn selectTbInById(Long id)
    {
        return tbInMapper.selectTbInById(id);
    }

    @Override
    public TbIn selectTbIn(TbIn tbIn) {
        return tbInMapper.selectTbIn(tbIn);
    }

    /**
     * 查询入库信息列表
     * 
     * @param tbIn 入库信息
     * @return 入库信息
     */
    @Override
    public List<TbIn> selectTbInList(TbIn tbIn)
    {
        return tbInMapper.selectTbInList(tbIn);
    }

    /**
     * 新增入库信息
     * 
     * @param tbIn 入库信息
     * @return 结果
     */
    @Override
    public int insertTbIn(TbIn tbIn)
    {
        return tbInMapper.insertTbIn(tbIn);
    }

    /**
     * 修改入库信息
     * 
     * @param tbIn 入库信息
     * @return 结果
     */
    @Override
    public int updateTbIn(TbIn tbIn)
    {
        return tbInMapper.updateTbIn(tbIn);
    }

    /**
     * 删除入库信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbInByIds(String ids)
    {
        return tbInMapper.deleteTbInByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除入库信息信息
     * 
     * @param id 入库信息ID
     * @return 结果
     */
    @Override
    public int deleteTbInById(Long id)
    {
        return tbInMapper.deleteTbInById(id);
    }
}
