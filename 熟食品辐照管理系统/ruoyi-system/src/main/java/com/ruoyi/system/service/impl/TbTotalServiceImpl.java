package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbTotalMapper;
import com.ruoyi.system.domain.TbTotal;
import com.ruoyi.system.service.ITbTotalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbTotalServiceImpl implements ITbTotalService 
{
    @Autowired
    private TbTotalMapper tbTotalMapper;

    /**
     * 查询库存信息
     * 
     * @param id 库存信息ID
     * @return 库存信息
     */
    @Override
    public TbTotal selectTbTotalById(Long id)
    {
        return tbTotalMapper.selectTbTotalById(id);
    }

    @Override
    public TbTotal selectTbTotal(TbTotal tbTotal) {
        return tbTotalMapper.selectTbTotal(tbTotal);
    }

    /**
     * 查询库存信息列表
     * 
     * @param tbTotal 库存信息
     * @return 库存信息
     */
    @Override
    public List<TbTotal> selectTbTotalList(TbTotal tbTotal)
    {
        return tbTotalMapper.selectTbTotalList(tbTotal);
    }

    /**
     * 新增库存信息
     * 
     * @param tbTotal 库存信息
     * @return 结果
     */
    @Override
    public int insertTbTotal(TbTotal tbTotal)
    {
        return tbTotalMapper.insertTbTotal(tbTotal);
    }

    /**
     * 修改库存信息
     * 
     * @param tbTotal 库存信息
     * @return 结果
     */
    @Override
    public int updateTbTotal(TbTotal tbTotal)
    {
        return tbTotalMapper.updateTbTotal(tbTotal);
    }

    /**
     * 删除库存信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbTotalByIds(String ids)
    {
        return tbTotalMapper.deleteTbTotalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除库存信息信息
     * 
     * @param id 库存信息ID
     * @return 结果
     */
    @Override
    public int deleteTbTotalById(Long id)
    {
        return tbTotalMapper.deleteTbTotalById(id);
    }
}
