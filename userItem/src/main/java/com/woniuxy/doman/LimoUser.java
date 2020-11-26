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
public class LimoUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    private String uName;

    private String uPassword;

    private String uEmail;

    private String uPhone;

    private Integer uAge;

    /**
     * 0 男 1 女
     */
    private Integer uSex;

    /**
     * 0 正常 1 不正常
     */
    private Integer uStatus;

    private LocalDateTime uRegisterTime;

    /**
     * 用户头像
     */
    private String uOne;

    private Integer uTwo;


    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public LocalDateTime getuRegisterTime() {
        return uRegisterTime;
    }

    public void setuRegisterTime(LocalDateTime uRegisterTime) {
        this.uRegisterTime = uRegisterTime;
    }

    public String getuOne() {
        return uOne;
    }

    public void setuOne(String uOne) {
        this.uOne = uOne;
    }

    public Integer getuTwo() {
        return uTwo;
    }

    public void setuTwo(Integer uTwo) {
        this.uTwo = uTwo;
    }

    @Override
    public String toString() {
        return "LimoUser{" +
        "uId=" + uId +
        ", uName=" + uName +
        ", uPassword=" + uPassword +
        ", uEmail=" + uEmail +
        ", uPhone=" + uPhone +
        ", uAge=" + uAge +
        ", uSex=" + uSex +
        ", uStatus=" + uStatus +
        ", uRegisterTime=" + uRegisterTime +
        ", uOne=" + uOne +
        ", uTwo=" + uTwo +
        "}";
    }
}
