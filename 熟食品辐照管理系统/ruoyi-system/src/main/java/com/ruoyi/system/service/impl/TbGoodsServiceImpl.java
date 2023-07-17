package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbGoodsMapper;
import com.ruoyi.system.domain.TbGoods;
import com.ruoyi.system.service.ITbGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbGoodsServiceImpl implements ITbGoodsService 
{
    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    /**
     * 查询产品信息
     * 
     * @param id 产品信息ID
     * @return 产品信息
     */
    @Override
    public TbGoods selectTbGoodsById(Long id)
    {
        return tbGoodsMapper.selectTbGoodsById(id);
    }

    /**
     * 查询产品信息列表
     * 
     * @param tbGoods 产品信息
     * @return 产品信息
     */
    @Override
    public List<TbGoods> selectTbGoodsList(TbGoods tbGoods)
    {
        return tbGoodsMapper.selectTbGoodsList(tbGoods);
    }

    /**
     * 新增产品信息
     * 
     * @param tbGoods 产品信息
     * @return 结果
     */
    @Override
    public int insertTbGoods(TbGoods tbGoods)
    {
        return tbGoodsMapper.insertTbGoods(tbGoods);
    }

    /**
     * 修改产品信息
     * 
     * @param tbGoods 产品信息
     * @return 结果
     */
    @Override
    public int updateTbGoods(TbGoods tbGoods)
    {
        return tbGoodsMapper.updateTbGoods(tbGoods);
    }

    /**
     * 删除产品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbGoodsByIds(String ids)
    {
        return tbGoodsMapper.deleteTbGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteTbGoodsById(Long id)
    {
        return tbGoodsMapper.deleteTbGoodsById(id);
    }
}
