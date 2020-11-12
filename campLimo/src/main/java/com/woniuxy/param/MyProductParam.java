package com.woniuxy.param;

import com.woniuxy.vo.PageVO;

import java.io.Serializable;

/**
 * @ClassName ProductParam
 * @Author shadow
 * @Date 2020/11/9 15:52
 * @Description TODO
 **/
public class MyProductParam extends PageVO implements Serializable {
    private Integer cId;
    private Integer pType;
    public MyProductParam() {
    }

    public MyProductParam(Integer cId, Integer pType) {
        this.cId = cId;
        this.pType = pType;
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

    @Override
    public String toString() {
        return "ProductParam{" +
                "cId=" + cId +
                ", pType=" + pType +
                '}';
    }
}
