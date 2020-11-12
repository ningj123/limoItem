package com.woniuxy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ev_id", type = IdType.AUTO)
    private Integer evId;

    private String evDes;

    private String evImages;

    private LocalDateTime evTime;

    /**
     * 活动编号
     */
    private Integer aId;

    private Integer pId;

    private Integer uId;

    /**
     * 0 商品评价 1活动评价
     */
    private Integer evType;

    private UserDto userDto;

}
