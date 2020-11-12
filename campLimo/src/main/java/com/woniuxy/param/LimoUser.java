package com.woniuxy.param;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName LimoUser
 * @Author shadow
 * @Date 2020/11/9 16:51
 * @Description TODO
 **/
public class LimoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer uId;
    private String uName;
    private String uPassword;
    private String uEmail;
    private String uPhone;
    private Integer uAge;
    private Integer uSex;
    private Integer uStatus;
    private Date uRegisterTime;

    public LimoUser() {
    }

    public LimoUser(Integer uId, String uName, String uPassword, String uEmail, String uPhone, Integer uAge, Integer uSex, Integer uStatus, Date uRegisterTime) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uEmail = uEmail;
        this.uPhone = uPhone;
        this.uAge = uAge;
        this.uSex = uSex;
        this.uStatus = uStatus;
        this.uRegisterTime = uRegisterTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Date getuRegisterTime() {
        return uRegisterTime;
    }

    public void setuRegisterTime(Date uRegisterTime) {
        this.uRegisterTime = uRegisterTime;
    }

    @Override
    public String toString() {
        return "LimoUser{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uAge=" + uAge +
                ", uSex=" + uSex +
                ", uStatus=" + uStatus +
                ", uRegisterTime=" + uRegisterTime +
                '}';
    }
}
