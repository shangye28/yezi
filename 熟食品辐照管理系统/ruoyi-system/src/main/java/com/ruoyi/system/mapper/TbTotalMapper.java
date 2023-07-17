package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbTotal;

/**
 * 库存信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface TbTotalMapper 
{
    /**
     * 查询库存信息
     * 
     * @param id 库存信息ID selectTbTotal
     * @return 库存信息
     */
    public TbTotal selectTbTotalById(Long id);
    public TbTotal selectTbTotal(TbTotal tbTotal);
    /**
     * 查询库存信息列表
     * 
     * @param tbTotal 库存信息
     * @return 库存信息集合
     */
    public List<TbTotal> selectTbTotalList(TbTotal tbTotal);

    /**
     * 新增库存信息
     * 
     * @param tbTotal 库存信息
     * @return 结果
     */
    public int insertTbTotal(TbTotal tbTotal);

    /**
     * 修改库存信息
     * 
     * @param tbTotal 库存信息
     * @return 结果
     */
    public int updateTbTotal(TbTotal tbTotal);

    /**
     * 删除库存信息
     * 
     * @param id 库存信息ID
     * @return 结果
     */
    public int deleteTbTotalById(Long id);

    /**
     * 批量删除库存信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbTotalByIds(String[] ids);
}
