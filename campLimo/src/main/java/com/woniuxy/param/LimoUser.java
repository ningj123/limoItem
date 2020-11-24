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
    private String uId;
    private String uName;
    private String uPassword;
    private String uEmail;

    public LimoUser() {
    }

    public LimoUser(String uId, String uName, String uPassword, String uEmail) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uEmail = uEmail;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    @Override
    public String toString() {
        return "LimoUser{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
