package com.woniuxy.dto;

import java.io.Serializable;

/**
 * @ClassName LimoDto
 * @Author shadow
 * @Date 2020/11/13 9:29
 * @Description TODO
 **/
public class LimoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pId;

    private String pName;

    private Integer pInven;

    private Double pOldPrice;

    private Double pNewPrice;

    private Double pSellPrice;

    private String pImages;

    private String pDes;

    /**
     * 0 美食 1 工具 2 房车 3 特色住宿 4 可以售卖的房车
     */
    private Integer pType;

    private Integer urId;

    private Integer cId;

    private Integer pStatus;

    /**
     * 城市字段
     */
    private String cCity;

    public LimoDto() {
    }

    public LimoDto(Integer pId, String pName, Integer pInven, Double pOldPrice, Double pNewPrice, Double pSellPrice, String pImages, String pDes, Integer pType, Integer urId, Integer cId, Integer pStatus, String cCity) {
        this.pId = pId;
        this.pName = pName;
        this.pInven = pInven;
        this.pOldPrice = pOldPrice;
        this.pNewPrice = pNewPrice;
        this.pSellPrice = pSellPrice;
        this.pImages = pImages;
        this.pDes = pDes;
        this.pType = pType;
        this.urId = urId;
        this.cId = cId;
        this.pStatus = pStatus;
        this.cCity = cCity;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getpInven() {
        return pInven;
    }

    public void setpInven(Integer pInven) {
        this.pInven = pInven;
    }

    public Double getpOldPrice() {
        return pOldPrice;
    }

    public void setpOldPrice(Double pOldPrice) {
        this.pOldPrice = pOldPrice;
    }

    public Double getpNewPrice() {
        return pNewPrice;
    }

    public void setpNewPrice(Double pNewPrice) {
        this.pNewPrice = pNewPrice;
    }

    public Double getpSellPrice() {
        return pSellPrice;
    }

    public void setpSellPrice(Double pSellPrice) {
        this.pSellPrice = pSellPrice;
    }

    public String getpImages() {
        return pImages;
    }

    public void setpImages(String pImages) {
        this.pImages = pImages;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    @Override
    public String toString() {
        return "LimoDto{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pInven=" + pInven +
                ", pOldPrice=" + pOldPrice +
                ", pNewPrice=" + pNewPrice +
                ", pSellPrice=" + pSellPrice +
                ", pImages='" + pImages + '\'' +
                ", pDes='" + pDes + '\'' +
                ", pType=" + pType +
                ", urId=" + urId +
                ", cId=" + cId +
                ", pStatus=" + pStatus +
                ", cCity='" + cCity + '\'' +
                '}';
    }
}
