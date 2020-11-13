package com.woniuxy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class LimoOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "or_id", type = IdType.AUTO)
    private Integer orId;

    private Integer pId;

    private Integer aId;

    private Integer pNum;

    private Double pPrice;

    private Double pTotal;

    private Integer orType;

    private Integer orStatus;

    private Integer oId;

    private LocalDateTime orStartTime;

    private LocalDateTime orEndTime;


}
