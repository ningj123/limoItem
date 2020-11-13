package com.woniuxy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public class LimoCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ca_id", type = IdType.AUTO)
    private Integer caId;

    private Integer pId;

    private Integer aId;

    private Integer pNum;

    private Integer caType;

    private Integer uId;

    /**
     * 0正常，1删除
     */
    private Integer caStatus;


    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
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

    public Integer getCaStatus() {
        return caStatus;
    }

    public void setCaStatus(Integer caStatus) {
        this.caStatus = caStatus;
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
        ", caStatus=" + caStatus +
        "}";
    }
}
