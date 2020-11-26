package com.woniuxy.doman;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cgx
 * @since 2020-11-07
 */
public class LimoEvaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ev_id", type = IdType.AUTO)
    private Integer evId;

    private String evDes;

    private String evImages;

    private LocalDateTime evTime;

    /**
     * 活动编号
     */
    private Integer aId;

    private Integer pId;

    private Integer uId;

    /**
     * 0 商品评价 1活动评价
     */
    private Integer evType;


    public Integer getEvId() {
        return evId;
    }

    public void setEvId(Integer evId) {
        this.evId = evId;
    }

    public String getEvDes() {
        return evDes;
    }

    public void setEvDes(String evDes) {
        this.evDes = evDes;
    }

    public String getEvImages() {
        return evImages;
    }

    public void setEvImages(String evImages) {
        this.evImages = evImages;
    }

    public LocalDateTime getEvTime() {
        return evTime;
    }

    public void setEvTime(LocalDateTime evTime) {
        this.evTime = evTime;
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

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getEvType() {
        return evType;
    }

    public void setEvType(Integer evType) {
        this.evType = evType;
    }

    @Override
    public String toString() {
        return "LimoEvaluate{" +
        "evId=" + evId +
        ", evDes=" + evDes +
        ", evImages=" + evImages +
        ", evTime=" + evTime +
        ", aId=" + aId +
        ", pId=" + pId +
        ", uId=" + uId +
        ", evType=" + evType +
        "}";
    }
}
