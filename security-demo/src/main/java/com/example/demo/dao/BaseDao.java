package com.example.demo.dao;

import java.util.List;

public interface BaseDao<T>{
    /**
     * 保存一个对象
     *
     * @param o
     * @return
     */
    public void save(T o);

    /**
     * 删除一个对象
     *
     * @param o
     */
    public void delete(T o);

    /**
     * 更新一个对象
     *
     * @param o
     */
    public void update(T o);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public T getById(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    public List<T> find();

    /**
     * 查询数据条数
     *
     * @return
     */
    public Long count();
}