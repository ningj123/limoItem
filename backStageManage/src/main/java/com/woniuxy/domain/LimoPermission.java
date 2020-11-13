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
public class LimoPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pe_id", type = IdType.AUTO)
    private Integer peId;

    private Integer rId;

    private Integer mId;


    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "LimoPermission{" +
        "peId=" + peId +
        ", rId=" + rId +
        ", mId=" + mId +
        "}";
    }
}
