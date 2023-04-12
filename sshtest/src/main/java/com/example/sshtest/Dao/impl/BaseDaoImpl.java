package com.example.sshtest.dao.impl;

import com.example.sshtest.dao.BaseDao;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository("BaseDAO")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {


    @PersistenceContext
    protected EntityManager entityManager;

    public void save(T o) {
        this.entityManager.persist(o);
    }

    public void delete(T o) {
        this.entityManager.remove(o);
    }

    public void update(T o) {
        this.entityManager.merge(o);
    }

//    public void saveOrUpdate(T o) {
//        this.getCurrentSession().saveOrUpdate(o);
//    }

    public List<T> find(String hql) {
        return this.entityManager.createNativeQuery(hql).getResultList();
    }

    public List<T> find(String hql, Map<String,Object> parameters) {
        Query q = this.entityManager.createNativeQuery(hql);
        Iterator<Map.Entry<String,Object>> entries = parameters.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String,Object> entry = entries.next();
            q.setParameter(entry.getKey(),entry.getValue());
        }

        List rows = q.getResultList();
        List<T> resultList=new ArrayList<T>();
        for (Object obj : rows) {
            T row=(T)obj;
            resultList.add(row);
        }
        return resultList;
    }

//    public List<T> find(String hql, Object[] param) {
//        Query q = this.entityManager.createNativeQuery(hql);
//        if (param != null && param.length > 0) {
//            for (int i = 0; i < param.length; i++) {
//                q.setParameter(i, param[i]);
//            }
//        }
//        return q.getResultList();
//    }

//    public List<T> find(String hql, List<Object> param) {
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.size() > 0) {
//            for (int i = 0; i < param.size(); i++) {
//                q.setParameter(i, param.get(i));
//            }
//        }
//        return q.list();
//    }
//
//    public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
//        if (page == null || page < 1) {
//            page = 1;
//        }
//        if (rows == null || rows < 1) {
//            rows = 10;
//        }
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.length > 0) {
//            for (int i = 0; i < param.length; i++) {
//                q.setParameter(i, param[i]);
//            }
//        }
//        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
//    }
//
//    public List<T> find(String hql, List<Object> param, Integer page,
//                        Integer rows) {
//        if (page == null || page < 1) {
//            page = 1;
//        }
//        if (rows == null || rows < 1) {
//            rows = 10;
//        }
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.size() > 0) {
//            for (int i = 0; i < param.size(); i++) {
//                q.setParameter(i, param.get(i));
//            }
//        }
//        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
//    }
//
//    public T get(Class<T> c, Serializable id) {
//        return (T) this.getCurrentSession().get(c, id);
//    }
//
    public T get(String hql, Map<String,Object> parameters) {
        List<T> l = this.find(hql, parameters);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

//    public T get(String hql, List<Object> param) {
//        List<T> l = this.find(hql, param);
//        if (l != null && l.size() > 0) {
//            return l.get(0);
//        } else {
//            return null;
//        }
//    }
//
//    public Long count(String hql) {
//        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
//    }
//
//    public Long count(String hql, Object[] param) {
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.length > 0) {
//            for (int i = 0; i < param.length; i++) {
//                q.setParameter(i, param[i]);
//            }
//        }
//        return (Long) q.uniqueResult();
//    }
//
//    public Long count(String hql, List<Object> param) {
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.size() > 0) {
//            for (int i = 0; i < param.size(); i++) {
//                q.setParameter(i, param.get(i));
//            }
//        }
//        return (Long) q.uniqueResult();
//    }
//
//    public Integer executeHql(String hql) {
//        return this.getCurrentSession().createQuery(hql).executeUpdate();
//    }
//
//    public Integer executeHql(String hql, Object[] param) {
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.length > 0) {
//            for (int i = 0; i < param.length; i++) {
//                q.setParameter(i, param[i]);
//            }
//        }
//        return q.executeUpdate();
//    }
//
//    public Integer executeHql(String hql, List<Object> param) {
//        Query q = this.getCurrentSession().createQuery(hql);
//        if (param != null && param.size() > 0) {
//            for (int i = 0; i < param.size(); i++) {
//                q.setParameter(i, param.get(i));
//            }
//        }
//        return q.executeUpdate();
//    }
}
