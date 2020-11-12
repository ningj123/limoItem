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
public class LimoSecSpot implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sec_id", type = IdType.AUTO)
    private Integer secId;

    private String secSportName;

    private String secSportAddress;

    private String secSportCity;

    private Integer cId;

    private String cName;

    private String secSportOpentime;

    private String secSportServer;

    private String secSportImgurl;

    private Double secSportPrice;


    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecSportName() {
        return secSportName;
    }

    public void setSecSportName(String secSportName) {
        this.secSportName = secSportName;
    }

    public String getSecSportAddress() {
        return secSportAddress;
    }

    public void setSecSportAddress(String secSportAddress) {
        this.secSportAddress = secSportAddress;
    }

    public String getSecSportCity() {
        return secSportCity;
    }

    public void setSecSportCity(String secSportCity) {
        this.secSportCity = secSportCity;
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

    public String getSecSportOpentime() {
        return secSportOpentime;
    }

    public void setSecSportOpentime(String secSportOpentime) {
        this.secSportOpentime = secSportOpentime;
    }

    public String getSecSportServer() {
        return secSportServer;
    }

    public void setSecSportServer(String secSportServer) {
        this.secSportServer = secSportServer;
    }

    public String getSecSportImgurl() {
        return secSportImgurl;
    }

    public void setSecSportImgurl(String secSportImgurl) {
        this.secSportImgurl = secSportImgurl;
    }

    public Double getSecSportPrice() {
        return secSportPrice;
    }

    public void setSecSportPrice(Double secSportPrice) {
        this.secSportPrice = secSportPrice;
    }

    @Override
    public String toString() {
        return "LimoSecSpot{" +
        "secId=" + secId +
        ", secSportName=" + secSportName +
        ", secSportAddress=" + secSportAddress +
        ", secSportCity=" + secSportCity +
        ", cId=" + cId +
        ", cName=" + cName +
        ", secSportOpentime=" + secSportOpentime +
        ", secSportServer=" + secSportServer +
        ", secSportImgurl=" + secSportImgurl +
        ", secSportPrice=" + secSportPrice +
        "}";
    }
}
