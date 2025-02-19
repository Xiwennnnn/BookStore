package com.xiwen.pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 7;

    private Integer pageNo;
    private Integer pageSize = PAGE_SIZE;
    private Integer totalCount;
    private Integer totalPage;

    private List<T> list;
    /**
     *分页条的请求地址
     */
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer totalCount, Integer totalPage, List<T> list, String url) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.url = url;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", url='" + url + '\'' +
                '}';
    }
}
