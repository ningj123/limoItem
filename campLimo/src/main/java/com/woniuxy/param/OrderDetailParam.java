package com.woniuxy.param;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderDetailParam
 * @Author shadow
 * @Date 2020/11/10 11:16
 * @Description TODO
 **/
public class OrderDetailParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pId;
    private Integer pNum;
    private double pPrice;
    private double pTotal;
    private Integer orType;
    private Date orStartTime;
    private Date orEndTime;
    private Integer oId;

    public OrderDetailParam() {
    }

    public OrderDetailParam(Integer pId, Integer pNum, double pPrice, double pTotal, Integer orType, Date orStartTime, Date orEndTime, Integer oId) {
        this.pId = pId;
        this.pNum = pNum;
        this.pPrice = pPrice;
        this.pTotal = pTotal;
        this.orType = orType;
        this.orStartTime = orStartTime;
        this.orEndTime = orEndTime;
        this.oId = oId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {
        this.pNum = pNum;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public double getpTotal() {
        return pTotal;
    }

    public void setpTotal(double pTotal) {
        this.pTotal = pTotal;
    }

    public Integer getOrType() {
        return orType;
    }

    public void setOrType(Integer orType) {
        this.orType = orType;
    }

    public Date getOrStartTime() {
        return orStartTime;
    }

    public void setOrStartTime(Date orStartTime) {
        this.orStartTime = orStartTime;
    }

    public Date getOrEndTime() {
        return orEndTime;
    }

    public void setOrEndTime(Date orEndTime) {
        this.orEndTime = orEndTime;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    @Override
    public String toString() {
        return "OrderDetailParam{" +
                "pId=" + pId +
                ", pNum=" + pNum +
                ", pPrice=" + pPrice +
                ", pTotal=" + pTotal +
                ", orType=" + orType +
                ", orStartTime=" + orStartTime +
                ", orEndTime=" + orEndTime +
                ", oId=" + oId +
                '}';
    }
}
