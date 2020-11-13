package com.woniuxy.vo;

import java.io.Serializable;

/**
 * @ClassName PageVO
 * @Author shadow
 * @Date 2020/11/12 16:12
 * @Description TODO
 **/
public class PageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pageNum;
    private Integer pageSize;

    public PageVO() {
    }

    public PageVO(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
