package com.woniuxy.dto;

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
public class CampDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    private String cName;

    private String cAddress;

    private String cPhone;

    private String cOpenTime;

    private String cSpecial;

    private String cCity;

    private String cDes;

    private String cImages;

    /**
     * 0正常，1不正常
     */
    private Integer cStatus;

    private Integer jId;

    private String cOne;

    private Integer cTwo;


    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getcOpenTime() {
        return cOpenTime;
    }

    public void setcOpenTime(String cOpenTime) {
        this.cOpenTime = cOpenTime;
    }

    public String getcSpecial() {
        return cSpecial;
    }

    public void setcSpecial(String cSpecial) {
        this.cSpecial = cSpecial;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcDes() {
        return cDes;
    }

    public void setcDes(String cDes) {
        this.cDes = cDes;
    }

    public String getcImages() {
        return cImages;
    }

    public void setcImages(String cImages) {
        this.cImages = cImages;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getcOne() {
        return cOne;
    }

    public void setcOne(String cOne) {
        this.cOne = cOne;
    }

    public Integer getcTwo() {
        return cTwo;
    }

    public void setcTwo(Integer cTwo) {
        this.cTwo = cTwo;
    }

    @Override
    public String toString() {
        return "LimoCamp{" +
        "cId=" + cId +
        ", cName=" + cName +
        ", cAddress=" + cAddress +
        ", cPhone=" + cPhone +
        ", cOpenTime=" + cOpenTime +
        ", cSpecial=" + cSpecial +
        ", cCity=" + cCity +
        ", cDes=" + cDes +
        ", cImages=" + cImages +
        ", cStatus=" + cStatus +
        ", jId=" + jId +
        ", cOne=" + cOne +
        ", cTwo=" + cTwo +
        "}";
    }
}
