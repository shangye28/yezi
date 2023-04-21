package com.example.sshtest.utils;

import java.util.*;
import javax.persistence.Query;

public class CRUDUtils<T> {

    public List<T> find(Query query, String key, String value) {
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

    public T  get(Query query, String key, String value) {
        query.setParameter(key,value);
        List<T> list = query.getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
