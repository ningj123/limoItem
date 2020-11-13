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
 * @since 2020-11-12
 */
public class LimoMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer mId;

    private String mName;

    private Integer mLevel;

    private Integer pId;

    private String mResource;


    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmLevel() {
        return mLevel;
    }

    public void setmLevel(Integer mLevel) {
        this.mLevel = mLevel;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getmResource() {
        return mResource;
    }

    public void setmResource(String mResource) {
        this.mResource = mResource;
    }

    @Override
    public String toString() {
        return "LimoMenu{" +
        "mId=" + mId +
        ", mName=" + mName +
        ", mLevel=" + mLevel +
        ", pId=" + pId +
        ", mResource=" + mResource +
        "}";
    }
}
