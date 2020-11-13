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
public class LimoCity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String city;

    private String cityUrl;

    private Integer tatol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(String cityUrl) {
        this.cityUrl = cityUrl;
    }

    public Integer getTatol() {
        return tatol;
    }

    public void setTatol(Integer tatol) {
        this.tatol = tatol;
    }

    @Override
    public String toString() {
        return "LimoCity{" +
        "id=" + id +
        ", city=" + city +
        ", cityUrl=" + cityUrl +
        ", tatol=" + tatol +
        "}";
    }
}
