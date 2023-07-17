package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbIn;

/**
 * 入库信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface TbInMapper 
{
    /**
     * 查询入库信息
     * 
     * @param id 入库信息ID selectTbIn
     * @return 入库信息
     */
    public TbIn selectTbInById(Long id);
    public TbIn selectTbIn(TbIn tbIn);
    /**
     * 查询入库信息列表
     * 
     * @param tbIn 入库信息
     * @return 入库信息集合
     */
    public List<TbIn> selectTbInList(TbIn tbIn);

    /**
     * 新增入库信息
     * 
     * @param tbIn 入库信息
     * @return 结果
     */
    public int insertTbIn(TbIn tbIn);

    /**
     * 修改入库信息
     * 
     * @param tbIn 入库信息
     * @return 结果
     */
    public int updateTbIn(TbIn tbIn);

    /**
     * 删除入库信息
     * 
     * @param id 入库信息ID
     * @return 结果
     */
    public int deleteTbInById(Long id);

    /**
     * 批量删除入库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbInByIds(String[] ids);
}
