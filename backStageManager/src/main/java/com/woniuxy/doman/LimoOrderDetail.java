package com.woniuxy.doman;

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
 * @author zhuyuli
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "or_id", type = IdType.AUTO)
    private Integer orId;

    /**
     * 活动编号
     */
    private Integer aId;

    private Integer pId;

    private Integer pNum;

    private Double pPrice;

    private Double pTotal;

    /**
     * 0 商品 1 活动 2 住宿
     */
    private Integer orType;

    /**
     * 0 待使用 1 正在使用 2 使用完成
     */
    private Integer orStatus;

    private Integer oId;

    private LocalDateTime orStartTime;

    private LocalDateTime orEndTime;


}
