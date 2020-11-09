package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * limo_collect
 * @author 
 */
@Data
public class LimoCollect implements Serializable {
    private Integer coId;

    private Integer pId;

    private Integer uId;

    private Integer cId;

    private Integer aId;

    private Integer coType;

    private Date coTime;

    private static final long serialVersionUID = 1L;
}