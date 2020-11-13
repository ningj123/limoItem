package com.woniuxy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public class LimoOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "or_id", type = IdType.AUTO)
    private Integer orId;

    /**
     * 活动编号
     */
    private Integer aId;

    private Integer pId;

    private Integer pNum;

    private Double pPrice;

    private Double pTotal;

    private Integer orType;

    private Integer orStatus;

    private Integer oId;

    private LocalDateTime orStartTime;

    private LocalDateTime orEndTime;


    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
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

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public Double getpTotal() {
        return pTotal;
    }

    public void setpTotal(Double pTotal) {
        this.pTotal = pTotal;
    }

    public Integer getOrType() {
        return orType;
    }

    public void setOrType(Integer orType) {
        this.orType = orType;
    }

    public Integer getOrStatus() {
        return orStatus;
    }

    public void setOrStatus(Integer orStatus) {
        this.orStatus = orStatus;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public LocalDateTime getOrStartTime() {
        return orStartTime;
    }

    public void setOrStartTime(LocalDateTime orStartTime) {
        this.orStartTime = orStartTime;
    }

    public LocalDateTime getOrEndTime() {
        return orEndTime;
    }

    public void setOrEndTime(LocalDateTime orEndTime) {
        this.orEndTime = orEndTime;
    }

    @Override
    public String toString() {
        return "LimoOrderDetail{" +
        "orId=" + orId +
        ", aId=" + aId +
        ", pId=" + pId +
        ", pNum=" + pNum +
        ", pPrice=" + pPrice +
        ", pTotal=" + pTotal +
        ", orType=" + orType +
        ", orStatus=" + orStatus +
        ", oId=" + oId +
        ", orStartTime=" + orStartTime +
        ", orEndTime=" + orEndTime +
        "}";
    }
}
