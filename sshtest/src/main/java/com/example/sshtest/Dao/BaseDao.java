package com.example.sshtest.Dao;

import java.util.List;

public interface BaseDao<T>{
    public void add(T entity);
    public void del(int id);
    public void update(T entity);
    public T get(int id);
    public T load(int id);
    List<T> selectAll();
}