package com.example.demo.domain.vo;

import java.util.List;


/**
 *  后端分页
 * @param <T>
 */
public class Pager<T> {
    private int pageSize; // 每页显示多少条记录

    private int currentPage; //当前第几页数据

    private int totalRecord; // 一共多少条记录

    private int totalPage; // 一共多少页记录

    private List<T> list; //要显示的数据

    public Pager(int pageNum, int pageSize, List<T> sourceList){
        if(sourceList == null || sourceList.isEmpty()){
            return;
        }
        // 总记录条数
        this.totalRecord = sourceList.size();
        // 每页显示多少条记录
        this.pageSize = pageSize;
        //获取总页数
        this.totalPage = this.totalRecord / this.pageSize;
        if(this.totalRecord % this.pageSize !=0){
            this.totalPage = this.totalPage + 1;
        }
        // 当前第几页数据
        this.currentPage = this.totalPage < pageNum ?  this.totalPage : pageNum;
        // 起始索引
        int fromIndex   = this.pageSize * (this.currentPage -1);
        // 结束索引
        int toIndex  = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord : this.pageSize * this.currentPage;
        this.list = sourceList.subList(fromIndex, toIndex);
    }

    public Pager(){

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
