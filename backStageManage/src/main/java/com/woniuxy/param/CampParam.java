package com.woniuxy.param;

import com.woniuxy.vo.PageVO;

import java.io.Serializable;

/**
 * @ClassName CampParam
 * @Author shadow
 * @Date 2020/11/12 16:13
 * @Description TODO
 **/
public class CampParam extends PageVO implements Serializable {
    private static final long serialVersionUID = 1L;
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

    private Integer mId;

    public CampParam(Integer cId, String cName, String cAddress, String cPhone, String cOpenTime, String cSpecial, String cCity, String cDes, String cImages, Integer cStatus, Integer mId) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
        this.cPhone = cPhone;
        this.cOpenTime = cOpenTime;
        this.cSpecial = cSpecial;
        this.cCity = cCity;
        this.cDes = cDes;
        this.cImages = cImages;
        this.cStatus = cStatus;
        this.mId = mId;
    }

    public CampParam() {
    }

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

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "CampParam{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cOpenTime='" + cOpenTime + '\'' +
                ", cSpecial='" + cSpecial + '\'' +
                ", cCity='" + cCity + '\'' +
                ", cDes='" + cDes + '\'' +
                ", cImages='" + cImages + '\'' +
                ", cStatus=" + cStatus +
                ", mId=" + mId +
                '}';
    }
}
