package com.woniuxy.param;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName JoinParam
 * @Author shadow
 * @Date 2020/11/10 9:55
 * @Description TODO
 **/
public class JoinParam implements Serializable {
    private Integer jId;

    /**
     * 所属人
     */
    private String jName;

    private String jPhone;

    private String jSerail;

    private String jLimoAddress;

    private String jLimoType;

    private Integer cId;

    private String jCardImages;

    private String jLimoImages;

    private Date jStartTime;

    private Date jEndTime;

    private Integer jType;

    private String jEmail;

    private String jRemark;

    /**
     * 营地名称
     */
    private String jCampName;

    /**
     * 0 加盟申请状态  1同意申请   2拒绝申请
     */
    private Integer jStatus;

    /**
     * 城市
     */
    private String city;

    private static final long serialVersionUID = 1L;

    public JoinParam() {
    }

    public JoinParam(Integer jId, String jName, String jPhone, String jSerail, String jLimoAddress, String jLimoType, Integer cId, String jCardImages, String jLimoImages, Date jStartTime, Date jEndTime, Integer jType, String jEmail, String jRemark, String jCampName, Integer jStatus, String city) {
        this.jId = jId;
        this.jName = jName;
        this.jPhone = jPhone;
        this.jSerail = jSerail;
        this.jLimoAddress = jLimoAddress;
        this.jLimoType = jLimoType;
        this.cId = cId;
        this.jCardImages = jCardImages;
        this.jLimoImages = jLimoImages;
        this.jStartTime = jStartTime;
        this.jEndTime = jEndTime;
        this.jType = jType;
        this.jEmail = jEmail;
        this.jRemark = jRemark;
        this.jCampName = jCampName;
        this.jStatus = jStatus;
        this.city = city;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getjPhone() {
        return jPhone;
    }

    public void setjPhone(String jPhone) {
        this.jPhone = jPhone;
    }

    public String getjSerail() {
        return jSerail;
    }

    public void setjSerail(String jSerail) {
        this.jSerail = jSerail;
    }

    public String getjLimoAddress() {
        return jLimoAddress;
    }

    public void setjLimoAddress(String jLimoAddress) {
        this.jLimoAddress = jLimoAddress;
    }

    public String getjLimoType() {
        return jLimoType;
    }

    public void setjLimoType(String jLimoType) {
        this.jLimoType = jLimoType;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getjCardImages() {
        return jCardImages;
    }

    public void setjCardImages(String jCardImages) {
        this.jCardImages = jCardImages;
    }

    public String getjLimoImages() {
        return jLimoImages;
    }

    public void setjLimoImages(String jLimoImages) {
        this.jLimoImages = jLimoImages;
    }

    public Date getjStartTime() {
        return jStartTime;
    }

    public void setjStartTime(Date jStartTime) {
        this.jStartTime = jStartTime;
    }

    public Date getjEndTime() {
        return jEndTime;
    }

    public void setjEndTime(Date jEndTime) {
        this.jEndTime = jEndTime;
    }

    public Integer getjType() {
        return jType;
    }

    public void setjType(Integer jType) {
        this.jType = jType;
    }

    public String getjEmail() {
        return jEmail;
    }

    public void setjEmail(String jEmail) {
        this.jEmail = jEmail;
    }

    public String getjRemark() {
        return jRemark;
    }

    public void setjRemark(String jRemark) {
        this.jRemark = jRemark;
    }

    public String getjCampName() {
        return jCampName;
    }

    public void setjCampName(String jCampName) {
        this.jCampName = jCampName;
    }

    public Integer getjStatus() {
        return jStatus;
    }

    public void setjStatus(Integer jStatus) {
        this.jStatus = jStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "JoinParam{" +
                "jId=" + jId +
                ", jName='" + jName + '\'' +
                ", jPhone='" + jPhone + '\'' +
                ", jSerail='" + jSerail + '\'' +
                ", jLimoAddress='" + jLimoAddress + '\'' +
                ", jLimoType='" + jLimoType + '\'' +
                ", cId=" + cId +
                ", jCardImages='" + jCardImages + '\'' +
                ", jLimoImages='" + jLimoImages + '\'' +
                ", jStartTime=" + jStartTime +
                ", jEndTime=" + jEndTime +
                ", jType=" + jType +
                ", jEmail='" + jEmail + '\'' +
                ", jRemark='" + jRemark + '\'' +
                ", jCampName='" + jCampName + '\'' +
                ", jStatus=" + jStatus +
                ", city='" + city + '\'' +
                '}';
    }
}
