package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * limo_order_detail
 * @author 
 */
@Data
public class LimoOrderDetail implements Serializable {
    private Integer orId;

    private Integer pId;

    private Integer pNum;

    private Double pPrice;

    private Double pTotal;

    private Integer orType;

    private Integer orStatus;

    private Integer oId;

    private Date orStartTime;

    private Date orEndTime;

    private static final long serialVersionUID = 1L;
}