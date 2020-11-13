package com.woniuxy.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName LimoActivityParam
 * @Author shadow
 * @Date 2020/11/13 14:56
 * @Description TODO
 **/
public class LimoActivityParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer aId;

    private String aName;

    /**
     * 库存
     */
    private Integer aInven;

    private String aImages;

    private String aDes;

    private Double aPrice;

    /**
     * 0 音乐 1 旅游 2 美食
     */
    private Integer aType;

    private Integer aSellNum;

    private LocalDateTime aSellTime;

    private LocalDateTime aStartTime;

    private LocalDateTime aEndTime;

    /**
     * 营地ID
     */
    private Integer cId;

    /**
     * 0 正在出售 1 停止出售
     */
    private Integer aStatus;

    /**
     * 传过来的城市
     */
    private String aCity;

    public LimoActivityParam() {
    }

    public LimoActivityParam(Integer aId, String aName, Integer aInven, String aImages, String aDes, Double aPrice, Integer aType, Integer aSellNum, LocalDateTime aSellTime, LocalDateTime aStartTime, LocalDateTime aEndTime, Integer cId, Integer aStatus, String aCity) {
        this.aId = aId;
        this.aName = aName;
        this.aInven = aInven;
        this.aImages = aImages;
        this.aDes = aDes;
        this.aPrice = aPrice;
        this.aType = aType;
        this.aSellNum = aSellNum;
        this.aSellTime = aSellTime;
        this.aStartTime = aStartTime;
        this.aEndTime = aEndTime;
        this.cId = cId;
        this.aStatus = aStatus;
        this.aCity = aCity;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getaInven() {
        return aInven;
    }

    public void setaInven(Integer aInven) {
        this.aInven = aInven;
    }

    public String getaImages() {
        return aImages;
    }

    public void setaImages(String aImages) {
        this.aImages = aImages;
    }

    public String getaDes() {
        return aDes;
    }

    public void setaDes(String aDes) {
        this.aDes = aDes;
    }

    public Double getaPrice() {
        return aPrice;
    }

    public void setaPrice(Double aPrice) {
        this.aPrice = aPrice;
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public Integer getaSellNum() {
        return aSellNum;
    }

    public void setaSellNum(Integer aSellNum) {
        this.aSellNum = aSellNum;
    }

    public LocalDateTime getaSellTime() {
        return aSellTime;
    }

    public void setaSellTime(LocalDateTime aSellTime) {
        this.aSellTime = aSellTime;
    }

    public LocalDateTime getaStartTime() {
        return aStartTime;
    }

    public void setaStartTime(LocalDateTime aStartTime) {
        this.aStartTime = aStartTime;
    }

    public LocalDateTime getaEndTime() {
        return aEndTime;
    }

    public void setaEndTime(LocalDateTime aEndTime) {
        this.aEndTime = aEndTime;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public String getaCity() {
        return aCity;
    }

    public void setaCity(String aCity) {
        this.aCity = aCity;
    }

    @Override
    public String toString() {
        return "LimoActivityParam{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aInven=" + aInven +
                ", aImages='" + aImages + '\'' +
                ", aDes='" + aDes + '\'' +
                ", aPrice=" + aPrice +
                ", aType=" + aType +
                ", aSellNum=" + aSellNum +
                ", aSellTime=" + aSellTime +
                ", aStartTime=" + aStartTime +
                ", aEndTime=" + aEndTime +
                ", cId=" + cId +
                ", aStatus=" + aStatus +
                ", aCity='" + aCity + '\'' +
                '}';
    }
}
