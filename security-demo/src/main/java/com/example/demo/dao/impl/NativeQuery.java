package com.example.demo.dao.impl;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
public class NativeQuery<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    public List<T> find(String sql, String key, String value, Class resultClass) {
        Query query = this.entityManager.createQuery(sql, resultClass);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put(key,value);
        Iterator<Map.Entry<String,Object>> entries = parameters.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String,Object> entry = entries.next();
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List rows = query.getResultList();
        List<T> resultList=new ArrayList<T>();
        for (Object obj : rows) {
            T row=(T)obj;
            resultList.add(row);
        }
        return resultList;
    }

    public T  get(String sql, String key, String value, Class resultClass) {
        Query query = this.entityManager.createQuery(sql, resultClass);
        query.setParameter(key,value);
        List<T> list = query.getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
