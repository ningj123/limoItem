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
public class LimoBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 0.首页广告，1 活动 2美食 3旅游指南
     */
    private Integer type;

    private Integer lianId;

    private Integer status;

    private Integer cId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLianId() {
        return lianId;
    }

    public void setLianId(Integer lianId) {
        this.lianId = lianId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "LimoBanner{" +
        "id=" + id +
        ", imgUrl=" + imgUrl +
        ", type=" + type +
        ", lianId=" + lianId +
        ", status=" + status +
        ", cId=" + cId +
        "}";
    }
}
