package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbOut;

/**
 * 出库信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface TbOutMapper 
{
    /**
     * 查询出库信息
     * 
     * @param id 出库信息ID
     * @return 出库信息
     */
    public TbOut selectTbOutById(Long id);

    /**
     * 查询出库信息列表
     * 
     * @param tbOut 出库信息
     * @return 出库信息集合
     */
    public List<TbOut> selectTbOutList(TbOut tbOut);

    /**
     * 新增出库信息
     * 
     * @param tbOut 出库信息
     * @return 结果
     */
    public int insertTbOut(TbOut tbOut);

    /**
     * 修改出库信息
     * 
     * @param tbOut 出库信息
     * @return 结果
     */
    public int updateTbOut(TbOut tbOut);

    /**
     * 删除出库信息
     * 
     * @param id 出库信息ID
     * @return 结果
     */
    public int deleteTbOutById(Long id);

    /**
     * 批量删除出库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbOutByIds(String[] ids);
}
