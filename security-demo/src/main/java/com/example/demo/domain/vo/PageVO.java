package com.example.demo.domain.vo;

import java.util.List;

/**
 * 前端分页
 * @param <T>
 */
public class PageVO<T> {
    private List<T> list;
    private Long total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
