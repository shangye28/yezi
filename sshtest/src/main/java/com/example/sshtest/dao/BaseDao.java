package com.example.sshtest.dao;



import java.util.List;
import java.util.Map;


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

//
//
//    /**
//     * 查询集合
//     *
//     * @param hql
//     * @return
//     */
//    public List<T> find(String hql, Class resultClass);
//
//    /**
//     * 查询集合
//     *
//     * @param hql
//     * @param parameters
//     * @return
//     */
//    public List<T> find(String hql, Map<String,Object> parameters, Class resultClass);
//
//    /**
//     * 获得一个对象
//     *
//     * @param hql
//     * @param parameters
//     * @return Object
//     */
//    public T get(String hql, Map<String,Object> parameters, Class resultClass);
//
//    /**
//     * select count(*) from 类
//     *
//     * @param hql
//     * @return
//     */
//    public Long count(String hql);
//
//    /**
//     * select count(*) from 类
//     *
//     * @param hql
//     * @param parameters
//     * @return
//     */
//    public Long count(String hql, Map<String,Object> parameters);
}