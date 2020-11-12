package com.woniuxy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuyanzu
 * @since 2020-11-12
 */
public class LimoProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "p_id", type = IdType.AUTO)
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

    private Integer jId;

    /**
     * 城市字段
     */
    private String cCity;

    private Integer pTwo;


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

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public Integer getpTwo() {
        return pTwo;
    }

    public void setpTwo(Integer pTwo) {
        this.pTwo = pTwo;
    }

    @Override
    public String toString() {
        return "LimoProduct{" +
        "pId=" + pId +
        ", pName=" + pName +
        ", pInven=" + pInven +
        ", pOldPrice=" + pOldPrice +
        ", pNewPrice=" + pNewPrice +
        ", pSellPrice=" + pSellPrice +
        ", pImages=" + pImages +
        ", pDes=" + pDes +
        ", pType=" + pType +
        ", urId=" + urId +
        ", cId=" + cId +
        ", pStatus=" + pStatus +
        ", jId=" + jId +
        ", cCity=" + cCity +
        ", pTwo=" + pTwo +
        "}";
    }
}
