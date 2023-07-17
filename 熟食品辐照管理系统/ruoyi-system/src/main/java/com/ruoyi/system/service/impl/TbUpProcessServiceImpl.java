package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbUpProcessMapper;
import com.ruoyi.system.domain.TbUpProcess;
import com.ruoyi.system.service.ITbUpProcessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 上货处理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-07
 */
@Service
public class TbUpProcessServiceImpl implements ITbUpProcessService 
{
    @Autowired
    private TbUpProcessMapper tbUpProcessMapper;

    /**
     * 查询上货处理
     * 
     * @param id 上货处理ID
     * @return 上货处理
     */
    @Override
    public TbUpProcess selectTbUpProcessById(Long id)
    {
        return tbUpProcessMapper.selectTbUpProcessById(id);
    }

    /**
     * 查询上货处理列表
     * 
     * @param tbUpProcess 上货处理
     * @return 上货处理
     */
    @Override
    public List<TbUpProcess> selectTbUpProcessList(TbUpProcess tbUpProcess)
    {
        return tbUpProcessMapper.selectTbUpProcessList(tbUpProcess);
    }

    /**
     * 新增上货处理
     * 
     * @param tbUpProcess 上货处理
     * @return 结果
     */
    @Override
    public int insertTbUpProcess(TbUpProcess tbUpProcess)
    {
        return tbUpProcessMapper.insertTbUpProcess(tbUpProcess);
    }

    /**
     * 修改上货处理
     * 
     * @param tbUpProcess 上货处理
     * @return 结果
     */
    @Override
    public int updateTbUpProcess(TbUpProcess tbUpProcess)
    {
        return tbUpProcessMapper.updateTbUpProcess(tbUpProcess);
    }

    /**
     * 删除上货处理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbUpProcessByIds(String ids)
    {
        return tbUpProcessMapper.deleteTbUpProcessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除上货处理信息
     * 
     * @param id 上货处理ID
     * @return 结果
     */
    @Override
    public int deleteTbUpProcessById(Long id)
    {
        return tbUpProcessMapper.deleteTbUpProcessById(id);
    }
}
