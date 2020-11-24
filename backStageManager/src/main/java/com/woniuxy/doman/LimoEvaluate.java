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
public class LimoEvaluate implements Serializable {

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


}
