package com.woniuxy.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDetailParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "or_id", type = IdType.AUTO)
    private Integer orId;

    private Integer pId;

    private Integer pNum;

    private Double pPrice;

    private Double pTotal;

    private Integer orType;

    private Integer orStatus;

    private Integer oId;

    private LocalDateTime orStartTime;

    private LocalDateTime orEndTime;



}
