package com.woniuxy.param;

import com.woniuxy.vo.PageVO;

import java.io.Serializable;

/**
 * @ClassName ProductParam
 * @Author shadow
 * @Date 2020/11/9 15:52
 * @Description TODO
 **/
public class ProductParam {
    private Integer cId;
    private Integer pType;
    private Integer pageNum;
    private Integer pageSize;
    public ProductParam() {
    }

    public ProductParam(Integer cId, Integer pType, Integer pageNum, Integer pageSize) {
        this.cId = cId;
        this.pType = pType;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
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
        return "ProductParam{" +
                "cId=" + cId +
                ", pType=" + pType +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
