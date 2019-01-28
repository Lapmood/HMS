package com.bdqn.utils;

import java.util.Arrays;
import java.util.List;

public class Page<T> {

    private int pageNum;//页码
    private int pageSize;//每页条数
    private long total;//总条数
    private int pages;//总页数
    private int navigatePages;//页面导航个数
    private int[] navigatepageNums;//分页导航数值
    private int start;//数据库 limit 起始值
    private List<T> list;//分页数据

    //分组分页数据
    public  void startPage(List<T> list){
        startPage(list,5);
    }

    public void startPage(List<T> list,int navigatePages){
        this.list = list;
        this.navigatePages = navigatePages;
        this.calcNavigatepageNums();
    }

    public void calcPages(){
        this.pages = (int)(total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
    }

    private void calcStart() {
        this.start = (pageNum - 1) * pageSize;
    }

    private void calcNavigatepageNums(){
        //System.out.println(this.pages+"进入"+this.navigatePages);
        if (this.pages <= this.navigatePages) {
            this.navigatepageNums = new int[this.pages];

            for(int i = 0; i < this.pages; ++i) {
                this.navigatepageNums[i] = i + 1;
            }
        } else {
            this.navigatepageNums = new int[this.navigatePages];
            int startNum = this.pageNum - this.navigatePages / 2;
            int endNum = this.pageNum + this.navigatePages / 2;
            if (startNum < 1) {
                startNum = 1;
                for(int i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = startNum++;
                }
            } else if (endNum > this.pages) {
                endNum = this.pages;

                for(int i = this.navigatePages - 1; i >= 0; --i) {
                    this.navigatepageNums[i] = endNum--;
                }
            } else {
                for(int i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    public Page(int pageNum,long total) {
        this(pageNum,8,total);
    }

    public Page(int pageNum, int pageSize,long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        calcPages();
        calcStart();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", pages=" + pages +
                ", navigatepageNums=" + Arrays.toString(navigatepageNums) +
                ", list=" + list +
                '}';
    }
}
