package com.example.sshtest.pojo.dto;

import java.util.List;

public class PageDTO<T> {
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
        return "PageDTO{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
