package com.woniuxy.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderDto
 * @Author shadow
 * @Date 2020/11/10 10:45
 * @Description TODO
 **/
public class OrderDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orId;
    private Integer pId;
    private Date orStartTime;
    private Date orEndTime;

    public OrderDto() {
    }

    public OrderDto(Integer orId, Integer pId, Date orStartTime, Date orEndTime) {
        this.orId = orId;
        this.pId = pId;
        this.orStartTime = orStartTime;
        this.orEndTime = orEndTime;
    }

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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

    @Override
    public String toString() {
        return "OrderDto{" +
                "orId=" + orId +
                ", pId=" + pId +
                ", orStartTime=" + orStartTime +
                ", orEndTime=" + orEndTime +
                '}';
    }
}
