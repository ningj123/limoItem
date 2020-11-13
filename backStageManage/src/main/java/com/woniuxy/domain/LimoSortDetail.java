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
 * @since 2020-11-12
 */
public class LimoSortDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "so_d_id", type = IdType.AUTO)
    private Integer soDId;

    private String soDName;

    private String soDDes;

    private String soDImages;

    private LocalDateTime soDIssueTime;

    /**
     * 0 热门 1 营地 2 美食 3 景区
     */
    private Integer soDType;

    private String soDCity;

    private Integer soId;

    /**
     * 0 开放 1 不开放
     */
    private Integer soDStatus;

    private String soDKeyword;

    /**
     * 点击量
     */
    private Integer soDTwo;


    public Integer getSoDId() {
        return soDId;
    }

    public void setSoDId(Integer soDId) {
        this.soDId = soDId;
    }

    public String getSoDName() {
        return soDName;
    }

    public void setSoDName(String soDName) {
        this.soDName = soDName;
    }

    public String getSoDDes() {
        return soDDes;
    }

    public void setSoDDes(String soDDes) {
        this.soDDes = soDDes;
    }

    public String getSoDImages() {
        return soDImages;
    }

    public void setSoDImages(String soDImages) {
        this.soDImages = soDImages;
    }

    public LocalDateTime getSoDIssueTime() {
        return soDIssueTime;
    }

    public void setSoDIssueTime(LocalDateTime soDIssueTime) {
        this.soDIssueTime = soDIssueTime;
    }

    public Integer getSoDType() {
        return soDType;
    }

    public void setSoDType(Integer soDType) {
        this.soDType = soDType;
    }

    public String getSoDCity() {
        return soDCity;
    }

    public void setSoDCity(String soDCity) {
        this.soDCity = soDCity;
    }

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public Integer getSoDStatus() {
        return soDStatus;
    }

    public void setSoDStatus(Integer soDStatus) {
        this.soDStatus = soDStatus;
    }

    public String getSoDKeyword() {
        return soDKeyword;
    }

    public void setSoDKeyword(String soDKeyword) {
        this.soDKeyword = soDKeyword;
    }

    public Integer getSoDTwo() {
        return soDTwo;
    }

    public void setSoDTwo(Integer soDTwo) {
        this.soDTwo = soDTwo;
    }

    @Override
    public String toString() {
        return "LimoSortDetail{" +
        "soDId=" + soDId +
        ", soDName=" + soDName +
        ", soDDes=" + soDDes +
        ", soDImages=" + soDImages +
        ", soDIssueTime=" + soDIssueTime +
        ", soDType=" + soDType +
        ", soDCity=" + soDCity +
        ", soId=" + soId +
        ", soDStatus=" + soDStatus +
        ", soDKeyword=" + soDKeyword +
        ", soDTwo=" + soDTwo +
        "}";
    }
}
