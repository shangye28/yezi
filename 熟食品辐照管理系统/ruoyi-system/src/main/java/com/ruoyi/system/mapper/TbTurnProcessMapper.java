package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbTurnProcess;

/**
 * 换成处理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
public interface TbTurnProcessMapper 
{
    /**
     * 查询换成处理
     * 
     * @param id 换成处理ID
     * @return 换成处理
     */
    public TbTurnProcess selectTbTurnProcessById(Long id);

    /**
     * 查询换成处理列表
     * 
     * @param tbTurnProcess 换成处理
     * @return 换成处理集合
     */
    public List<TbTurnProcess> selectTbTurnProcessList(TbTurnProcess tbTurnProcess);

    /**
     * 新增换成处理
     * 
     * @param tbTurnProcess 换成处理
     * @return 结果
     */
    public int insertTbTurnProcess(TbTurnProcess tbTurnProcess);

    /**
     * 修改换成处理
     * 
     * @param tbTurnProcess 换成处理
     * @return 结果
     */
    public int updateTbTurnProcess(TbTurnProcess tbTurnProcess);

    /**
     * 删除换成处理
     * 
     * @param id 换成处理ID
     * @return 结果
     */
    public int deleteTbTurnProcessById(Long id);

    /**
     * 批量删除换成处理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbTurnProcessByIds(String[] ids);
}
