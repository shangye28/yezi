package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbGoods;

/**
 * 产品信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface ITbGoodsService 
{
    /**
     * 查询产品信息
     * 
     * @param id 产品信息ID
     * @return 产品信息
     */
    public TbGoods selectTbGoodsById(Long id);

    /**
     * 查询产品信息列表
     * 
     * @param tbGoods 产品信息
     * @return 产品信息集合
     */
    public List<TbGoods> selectTbGoodsList(TbGoods tbGoods);

    /**
     * 新增产品信息
     * 
     * @param tbGoods 产品信息
     * @return 结果
     */
    public int insertTbGoods(TbGoods tbGoods);

    /**
     * 修改产品信息
     * 
     * @param tbGoods 产品信息
     * @return 结果
     */
    public int updateTbGoods(TbGoods tbGoods);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbGoodsByIds(String ids);

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息ID
     * @return 结果
     */
    public int deleteTbGoodsById(Long id);
}
