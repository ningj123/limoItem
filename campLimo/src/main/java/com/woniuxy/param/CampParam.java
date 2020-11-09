package com.woniuxy.param;

import com.woniuxy.vo.PageVO;

import java.io.Serializable;

/**
 * @ClassName CampParam
 * @Author shadow
 * @Date 2020/11/9 11:01
 * @Description TODO
 **/
public class CampParam extends PageVO implements Serializable {
    private String cCity;

    public String getCCity() {
        return cCity;
    }

    public void setCCity(String cCity) {
        this.cCity = cCity;
    }
}
