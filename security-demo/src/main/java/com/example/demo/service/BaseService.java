package com.example.demo.service;

import com.example.demo.domain.vo.PageVO;

public interface BaseService<T> {
    public PageVO<T> findAll();

    public void delete(T o);

    public void save(T o);

    public void update(T o);
}
