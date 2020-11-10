package com.woniuxy.param;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderParam
 * @Author shadow
 * @Date 2020/11/10 10:36
 * @Description TODO
 **/
public class OrderParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer uId;
    private Integer cId;
    private double oTotal;
    private List<OrderDetailParam> list;

    public OrderParam() {
    }

    public OrderParam(Integer uId, Integer cId, double oTotal, List<OrderDetailParam> list) {
        this.uId = uId;
        this.cId = cId;
        this.oTotal = oTotal;
        this.list = list;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public double getoTotal() {
        return oTotal;
    }

    public void setoTotal(double oTotal) {
        this.oTotal = oTotal;
    }

    public List<OrderDetailParam> getList() {
        return list;
    }

    public void setList(List<OrderDetailParam> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "OrderParam{" +
                "uId=" + uId +
                ", cId=" + cId +
                ", oTotal=" + oTotal +
                ", list=" + list +
                '}';
    }
}
