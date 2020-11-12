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
 * @author wuyanzu
 * @since 2020-11-12
 */
public class LimoCollect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "co_id", type = IdType.AUTO)
    private Integer coId;

    private Integer pId;

    private Integer uId;

    private Integer cId;

    private Integer aId;

    private Integer coType;

    private LocalDateTime coTime;


    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getCoType() {
        return coType;
    }

    public void setCoType(Integer coType) {
        this.coType = coType;
    }

    public LocalDateTime getCoTime() {
        return coTime;
    }

    public void setCoTime(LocalDateTime coTime) {
        this.coTime = coTime;
    }

    @Override
    public String toString() {
        return "LimoCollect{" +
        "coId=" + coId +
        ", pId=" + pId +
        ", uId=" + uId +
        ", cId=" + cId +
        ", aId=" + aId +
        ", coType=" + coType +
        ", coTime=" + coTime +
        "}";
    }
}
