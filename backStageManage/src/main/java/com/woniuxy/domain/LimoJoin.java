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
 * @since 2020-11-13
 */
public class LimoJoin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "j_id", type = IdType.AUTO)
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

    private LocalDateTime jStartTime;

    private LocalDateTime jEndTime;

    private Integer jType;

    private String jEmail;

    private String jRemark;

    /**
     * 营地名称
     */
    private String jCampName;

    /**
     * 0 正在审核 1 同意 2 拒绝
     */
    private Integer jStatus;

    /**
     * 城市
     */
    private String city;


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

    public LocalDateTime getjStartTime() {
        return jStartTime;
    }

    public void setjStartTime(LocalDateTime jStartTime) {
        this.jStartTime = jStartTime;
    }

    public LocalDateTime getjEndTime() {
        return jEndTime;
    }

    public void setjEndTime(LocalDateTime jEndTime) {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "LimoJoin{" +
        "jId=" + jId +
        ", jName=" + jName +
        ", jPhone=" + jPhone +
        ", jSerail=" + jSerail +
        ", jLimoAddress=" + jLimoAddress +
        ", jLimoType=" + jLimoType +
        ", cId=" + cId +
        ", jCardImages=" + jCardImages +
        ", jLimoImages=" + jLimoImages +
        ", jStartTime=" + jStartTime +
        ", jEndTime=" + jEndTime +
        ", jType=" + jType +
        ", jEmail=" + jEmail +
        ", jRemark=" + jRemark +
        ", jCampName=" + jCampName +
        ", jStatus=" + jStatus +
        ", city=" + city +
        "}";
    }
}
