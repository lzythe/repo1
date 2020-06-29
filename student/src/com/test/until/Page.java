package com.test.until;

import com.test.entity.student;

import java.util.List;

public class Page {


    private int currentPage;//当前页
    private int pagesize;//每页显示的条数
    private int totalPage;//总页数
    private int totaCount;//总条数
    private List<student> pageList;//每页数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotaCount() {
        return totaCount;
    }

    public void setTotaCount(int totaCount) {
        this.totaCount = totaCount;
    }

    public List<student> getPageList() {
        return pageList;
    }

    public void setPageList(List<student> pageList) {
        this.pageList = pageList;
    }
}
