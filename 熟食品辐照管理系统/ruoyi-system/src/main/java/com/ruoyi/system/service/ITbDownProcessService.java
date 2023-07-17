package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbDownProcess;

/**
 * 卸货处理Service接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface ITbDownProcessService 
{
    /**
     * 查询卸货处理
     * 
     * @param id 卸货处理ID
     * @return 卸货处理
     */
    public TbDownProcess selectTbDownProcessById(Long id);

    /**
     * 查询卸货处理列表
     * 
     * @param tbDownProcess 卸货处理
     * @return 卸货处理集合
     */
    public List<TbDownProcess> selectTbDownProcessList(TbDownProcess tbDownProcess);

    /**
     * 新增卸货处理
     * 
     * @param tbDownProcess 卸货处理
     * @return 结果
     */
    public int insertTbDownProcess(TbDownProcess tbDownProcess);

    /**
     * 修改卸货处理
     * 
     * @param tbDownProcess 卸货处理
     * @return 结果
     */
    public int updateTbDownProcess(TbDownProcess tbDownProcess);

    /**
     * 批量删除卸货处理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbDownProcessByIds(String ids);

    /**
     * 删除卸货处理信息
     * 
     * @param id 卸货处理ID
     * @return 结果
     */
    public int deleteTbDownProcessById(Long id);
}
