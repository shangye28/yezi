package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository("BaseDAO")
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

//    public List<T> find(String hql, Class resultClass) {
//        Query q = this.entityManager.createQuery(hql,resultClass);
//        List<T> resultList = q.getResultList();
//        return resultList;
//    }
//
//    public List<T> find(String hql, Map<String,Object> parameters, Class resultClass) {
//        Query q = this.entityManager.createQuery(hql,resultClass);
//        Iterator<Map.Entry<String,Object>> entries = parameters.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<String,Object> entry = entries.next();
//            q.setParameter(entry.getKey(),entry.getValue());
//        }
//
//        List rows = q.getResultList();
//        List<T> resultList=new ArrayList<T>();
//        for (Object obj : rows) {
//            T row=(T)obj;
//            resultList.add(row);
//        }
//        return resultList;
//    }

//    public T  get(String hql, Map<String,Object> parameters, Class resultClass) {
//        List<T> l = this.find(hql, parameters, resultClass);
//        if (l != null && l.size() > 0) {
//            return l.get(0);
//        } else {
//            return null;
//        }
//    }
//
//
//    public Long count(String hql) {
//        Query q = this.entityManager.createQuery(hql);
//        Long result = (Long) q.getSingleResult();
//        return result;
//    }
//
//    public Long count(String hql, Map<String,Object> parameters) {
//        Query q = this.entityManager.createQuery(hql);
//        Iterator<Map.Entry<String,Object>> entries = parameters.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<String,Object> entry = entries.next();
//            q.setParameter(entry.getKey(),entry.getValue());
//        }
//        Long result = (Long) q.getSingleResult();
//        return result;
//    }
//
}
