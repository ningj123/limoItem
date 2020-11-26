package com.woniuxy.doman;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cgx
 * @since 2020-11-07
 */
public class LimoCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ca_id", type = IdType.AUTO)
    private Integer caId;

    private String pId;

    private Integer aId;

    private Integer pNum;

    private Integer caType;

    private Integer uId;


    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {
        this.pNum = pNum;
    }

    public Integer getCaType() {
        return caType;
    }

    public void setCaType(Integer caType) {
        this.caType = caType;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "LimoCart{" +
        "caId=" + caId +
        ", pId=" + pId +
        ", aId=" + aId +
        ", pNum=" + pNum +
        ", caType=" + caType +
        ", uId=" + uId +
        "}";
    }
}
