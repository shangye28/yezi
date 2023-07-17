package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbOutMapper;
import com.ruoyi.system.domain.TbOut;
import com.ruoyi.system.service.ITbOutService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出库信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbOutServiceImpl implements ITbOutService 
{
    @Autowired
    private TbOutMapper tbOutMapper;

    /**
     * 查询出库信息
     * 
     * @param id 出库信息ID
     * @return 出库信息
     */
    @Override
    public TbOut selectTbOutById(Long id)
    {
        return tbOutMapper.selectTbOutById(id);
    }

    /**
     * 查询出库信息列表
     * 
     * @param tbOut 出库信息
     * @return 出库信息
     */
    @Override
    public List<TbOut> selectTbOutList(TbOut tbOut)
    {
        return tbOutMapper.selectTbOutList(tbOut);
    }

    /**
     * 新增出库信息
     * 
     * @param tbOut 出库信息
     * @return 结果
     */
    @Override
    public int insertTbOut(TbOut tbOut)
    {
        return tbOutMapper.insertTbOut(tbOut);
    }

    /**
     * 修改出库信息
     * 
     * @param tbOut 出库信息
     * @return 结果
     */
    @Override
    public int updateTbOut(TbOut tbOut)
    {
        return tbOutMapper.updateTbOut(tbOut);
    }

    /**
     * 删除出库信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbOutByIds(String ids)
    {
        return tbOutMapper.deleteTbOutByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除出库信息信息
     * 
     * @param id 出库信息ID
     * @return 结果
     */
    @Override
    public int deleteTbOutById(Long id)
    {
        return tbOutMapper.deleteTbOutById(id);
    }
}
