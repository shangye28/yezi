package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbUpProcess;

/**
 * 上货处理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface TbUpProcessMapper 
{
    /**
     * 查询上货处理
     * 
     * @param id 上货处理ID
     * @return 上货处理
     */
    public TbUpProcess selectTbUpProcessById(Long id);

    /**
     * 查询上货处理列表
     * 
     * @param tbUpProcess 上货处理
     * @return 上货处理集合
     */
    public List<TbUpProcess> selectTbUpProcessList(TbUpProcess tbUpProcess);

    /**
     * 新增上货处理
     * 
     * @param tbUpProcess 上货处理
     * @return 结果
     */
    public int insertTbUpProcess(TbUpProcess tbUpProcess);

    /**
     * 修改上货处理
     * 
     * @param tbUpProcess 上货处理
     * @return 结果
     */
    public int updateTbUpProcess(TbUpProcess tbUpProcess);

    /**
     * 删除上货处理
     * 
     * @param id 上货处理ID
     * @return 结果
     */
    public int deleteTbUpProcessById(Long id);

    /**
     * 批量删除上货处理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbUpProcessByIds(String[] ids);
}
