package com.woniuxy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "o_id", type = IdType.AUTO)
    private Integer oId;

    private LocalDateTime oTime;

    private Integer oStatus;

    private Double oTotal;

    private Integer uId;

    private Integer cId;

    private Integer urId;

    private List<OrderDetailDto> orderDetailDtos;
}
