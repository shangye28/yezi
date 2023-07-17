package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbDownProcessMapper;
import com.ruoyi.system.domain.TbDownProcess;
import com.ruoyi.system.service.ITbDownProcessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 卸货处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbDownProcessServiceImpl implements ITbDownProcessService 
{
    @Autowired
    private TbDownProcessMapper tbDownProcessMapper;

    /**
     * 查询卸货处理
     * 
     * @param id 卸货处理ID
     * @return 卸货处理
     */
    @Override
    public TbDownProcess selectTbDownProcessById(Long id)
    {
        return tbDownProcessMapper.selectTbDownProcessById(id);
    }

    /**
     * 查询卸货处理列表
     * 
     * @param tbDownProcess 卸货处理
     * @return 卸货处理
     */
    @Override
    public List<TbDownProcess> selectTbDownProcessList(TbDownProcess tbDownProcess)
    {
        return tbDownProcessMapper.selectTbDownProcessList(tbDownProcess);
    }

    /**
     * 新增卸货处理
     * 
     * @param tbDownProcess 卸货处理
     * @return 结果
     */
    @Override
    public int insertTbDownProcess(TbDownProcess tbDownProcess)
    {
        return tbDownProcessMapper.insertTbDownProcess(tbDownProcess);
    }

    /**
     * 修改卸货处理
     * 
     * @param tbDownProcess 卸货处理
     * @return 结果
     */
    @Override
    public int updateTbDownProcess(TbDownProcess tbDownProcess)
    {
        return tbDownProcessMapper.updateTbDownProcess(tbDownProcess);
    }

    /**
     * 删除卸货处理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbDownProcessByIds(String ids)
    {
        return tbDownProcessMapper.deleteTbDownProcessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卸货处理信息
     * 
     * @param id 卸货处理ID
     * @return 结果
     */
    @Override
    public int deleteTbDownProcessById(Long id)
    {
        return tbDownProcessMapper.deleteTbDownProcessById(id);
    }
}
