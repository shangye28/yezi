package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDao;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository("BaseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> clazz;

    public BaseDaoImpl() {
        //获取泛型的class类型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            this.clazz = (Class<T>) actualTypeArguments[0];
        }
    }

    public void save(T o) {
        this.entityManager.persist(o);
    }

    public void delete(T o) {
        this.entityManager.remove(o);
    }

    public void update(T o) {
        this.entityManager.merge(o);
    }

    public T getById(Integer id){
        return (T) this.entityManager.find(clazz, id);
    }

    public List<T> find(){
        String hql = "from " + clazz.getSimpleName();
        Query q = this.entityManager.createQuery(hql, clazz);
        List<T> resultList = q.getResultList();
        return resultList;
    }

    public Long count(){
        String hql = "select count(*) from " + clazz.getSimpleName();
        Query q = this.entityManager.createQuery(hql);
        Long total = (Long) q.getSingleResult();
        return total;
    }
}
