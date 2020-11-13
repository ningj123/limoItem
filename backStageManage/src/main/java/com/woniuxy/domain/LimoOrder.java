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
public class LimoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "o_id", type = IdType.AUTO)
    private Integer oId;

    private LocalDateTime oTime;

    private Integer oStatus;

    private Double oTotal;

    private Integer uId;

    private Integer cId;

    private Integer urId;

    /**
     * 营地活动id
     */
    private Integer aId;


    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public LocalDateTime getoTime() {
        return oTime;
    }

    public void setoTime(LocalDateTime oTime) {
        this.oTime = oTime;
    }

    public Integer getoStatus() {
        return oStatus;
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public Double getoTotal() {
        return oTotal;
    }

    public void setoTotal(Double oTotal) {
        this.oTotal = oTotal;
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

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "LimoOrder{" +
        "oId=" + oId +
        ", oTime=" + oTime +
        ", oStatus=" + oStatus +
        ", oTotal=" + oTotal +
        ", uId=" + uId +
        ", cId=" + cId +
        ", urId=" + urId +
        ", aId=" + aId +
        "}";
    }
}
