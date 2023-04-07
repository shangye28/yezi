package com.example.sshtest.Dao.impl;

import com.example.sshtest.Dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();

    }

    private Class<T> clazz;
    public BaseDaoImpl() {
    //通过反射机制获取子类传递过来的实体类的类型信息

        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz=(Class<T>) type.getActualTypeArguments()[0];
    }
    @Override
    public void add(T entity) {
// TODO Auto-generated method stub
        getSession().save(entity);
    }

    @Override
    public void del(int id) {
// TODO Auto-generated method stub
        T t=get(id);
        getSession().delete(t);
    }

    @Override
    public void update(T entity) {
// TODO Auto-generated method stub
        getSession().update(entity);

    }

    @Override
    public T get(int id) {
// TODO Auto-generated method stub
        return (T)getSession().get(clazz, id);
    }

    @Override
    public T load(int id) {
// TODO Auto-generated method stub
        T t=(T)getSession().load(clazz, id);
        return t;
    }

    @Override
    public List<T> selectAll() {
        System.out.println("--"+this.clazz.getSimpleName());
        String hql="from "+this.clazz.getSimpleName();
        Query query=getSession().createQuery(hql);
        List<T> list=(List<T>)query.list();
        return list;
    }

}
