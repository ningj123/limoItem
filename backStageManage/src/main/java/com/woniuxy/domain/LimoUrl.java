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
public class LimoUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ur_id", type = IdType.AUTO)
    private Integer urId;

    private String urName;

    private Integer cId;


    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "LimoUrl{" +
        "urId=" + urId +
        ", urName=" + urName +
        ", cId=" + cId +
        "}";
    }
}
