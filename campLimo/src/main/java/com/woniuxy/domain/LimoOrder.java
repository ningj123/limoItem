package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * limo_order
 * @author 
 */
@Data
public class LimoOrder implements Serializable {
    private Integer oId;

    private Date oTime;

    private Integer oStatus;

    private Double oTotal;

    private Integer uId;

    private Integer cId;

    private Integer urId;

    private static final long serialVersionUID = 1L;
}