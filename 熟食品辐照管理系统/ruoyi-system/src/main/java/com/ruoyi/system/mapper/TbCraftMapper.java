package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbCraft;

/**
 * 辐射工艺处理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface TbCraftMapper 
{
    /**
     * 查询辐射工艺处理
     * 
     * @param id 辐射工艺处理ID
     * @return 辐射工艺处理
     */
    public TbCraft selectTbCraftById(Long id);

    /**
     * 查询辐射工艺处理列表
     * 
     * @param tbCraft 辐射工艺处理
     * @return 辐射工艺处理集合
     */
    public List<TbCraft> selectTbCraftList(TbCraft tbCraft);

    /**
     * 新增辐射工艺处理
     * 
     * @param tbCraft 辐射工艺处理
     * @return 结果
     */
    public int insertTbCraft(TbCraft tbCraft);

    /**
     * 修改辐射工艺处理
     * 
     * @param tbCraft 辐射工艺处理
     * @return 结果
     */
    public int updateTbCraft(TbCraft tbCraft);

    /**
     * 删除辐射工艺处理
     * 
     * @param id 辐射工艺处理ID
     * @return 结果
     */
    public int deleteTbCraftById(Long id);

    /**
     * 批量删除辐射工艺处理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbCraftByIds(String[] ids);
}
