package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbTurnProcessMapper;
import com.ruoyi.system.domain.TbTurnProcess;
import com.ruoyi.system.service.ITbTurnProcessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 换成处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbTurnProcessServiceImpl implements ITbTurnProcessService 
{
    @Autowired
    private TbTurnProcessMapper tbTurnProcessMapper;

    /**
     * 查询换成处理
     * 
     * @param id 换成处理ID
     * @return 换成处理
     */
    @Override
    public TbTurnProcess selectTbTurnProcessById(Long id)
    {
        return tbTurnProcessMapper.selectTbTurnProcessById(id);
    }

    /**
     * 查询换成处理列表
     * 
     * @param tbTurnProcess 换成处理
     * @return 换成处理
     */
    @Override
    public List<TbTurnProcess> selectTbTurnProcessList(TbTurnProcess tbTurnProcess)
    {
        return tbTurnProcessMapper.selectTbTurnProcessList(tbTurnProcess);
    }

    /**
     * 新增换成处理
     * 
     * @param tbTurnProcess 换成处理
     * @return 结果
     */
    @Override
    public int insertTbTurnProcess(TbTurnProcess tbTurnProcess)
    {
        return tbTurnProcessMapper.insertTbTurnProcess(tbTurnProcess);
    }

    /**
     * 修改换成处理
     * 
     * @param tbTurnProcess 换成处理
     * @return 结果
     */
    @Override
    public int updateTbTurnProcess(TbTurnProcess tbTurnProcess)
    {
        return tbTurnProcessMapper.updateTbTurnProcess(tbTurnProcess);
    }

    /**
     * 删除换成处理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbTurnProcessByIds(String ids)
    {
        return tbTurnProcessMapper.deleteTbTurnProcessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除换成处理信息
     * 
     * @param id 换成处理ID
     * @return 结果
     */
    @Override
    public int deleteTbTurnProcessById(Long id)
    {
        return tbTurnProcessMapper.deleteTbTurnProcessById(id);
    }
}
