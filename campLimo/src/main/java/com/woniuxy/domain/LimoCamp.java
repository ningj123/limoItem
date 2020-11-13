package com.woniuxy.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * limo_camp
 * @author 
 */
@Data
public class LimoCamp implements Serializable {
    private Integer cId;

    private String cName;

    private String cAddress;

    private String cPhone;

    private String cOpenTime;

    private String cSpecial;

    private String cCity;

    private String cDes;

    private String cImages;

    /**
     * 0正常，1不正常
     */
    private Integer cStatus;

    private Integer jId;

    private String cOne;

    private Integer mId;

    private static final long serialVersionUID = 1L;
}