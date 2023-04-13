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
     * 查询集合
     *
     * @param hql
     * @return
     */
    public List<T> find(String hql, Class resultClass);

    /**
     * 查询集合
     *
     * @param hql
     * @param parameters
     * @return
     */
    public List<T> find(String hql, Map<String,Object> parameters, Class resultClass);

//    /**
//     * 分页查询
//     *
//     * @param hql
//     * @return
//     */
//    public Pager<T> pageList(String hql);
//
//    /**
//     * 分页查询
//     *
//     * @param hql
//     * @param parameters
//     * @return
//     */
//    public Pager<T> pageList(String hql, Map<String,Object> parameters);

//    /**
//     * 查询集合(带分页)
//     *
//     * @param hql
//     * @param param
//     * @param page
//     *            查询第几页
//     * @param rows
//     *            每页显示几条记录
//     * @return
//     */
//    public List<T> find(String hql, Object[] param, Integer page, Integer rows);
//
//    /**
//     * 查询集合(带分页)
//     *
//     * @param hql
//     * @param param
//     * @param page
//     * @param rows
//     * @return
//     */
//    public List<T> find(String hql, List<Object> param, Integer page, Integer rows);
//
//    /**
//     * 获得一个对象
//     *
//     * @param c
//     *            对象类型
//     * @param id
//     * @return Object
//     */
//    public T get(Class<T> c, Serializable id);
//
    /**
     * 获得一个对象
     *
     * @param hql
     * @param parameters
     * @return Object
     */
    public T get(String hql, Map<String,Object> parameters, Class resultClass);
//
//    /**
//     * 获得一个对象
//     *
//     * @param hql
//     * @param param
//     * @return
//     */
//    public T get(String hql, List<Object> param);

    /**
     * select count(*) from 类
     *
     * @param hql
     * @return
     */
    public Long count(String hql);

    /**
     * select count(*) from 类
     *
     * @param hql
     * @param parameters
     * @return
     */
    public Long count(String hql, Map<String,Object> parameters);
//
//    /**
//     * select count(*) from 类
//     *
//     * @param hql
//     * @param param
//     * @return
//     */
//    public Long count(String hql, List<Object> param);
//
//    /**
//     * 执行HQL语句
//     *
//     * @param hql
//     * @return 响应数目
//     */
//    public Integer executeHql(String hql);
//
//    /**
//     * 执行HQL语句
//     *
//     * @param hql
//     * @param param
//     * @return 响应数目
//     */
//    public Integer executeHql(String hql, Object[] param);
//
//    /**
//     * 执行HQL语句
//     *
//     * @param hql
//     * @param param
//     * @return
//     */
//    public Integer executeHql(String hql, List<Object> param);
}