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
public class LimoAppointDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "apd_id", type = IdType.AUTO)
    private Integer apdId;

    private Integer hId;

    private Integer reId;

    private Double apdTotal;

    private Integer apdType;

    private LocalDateTime apdStartTime;

    private LocalDateTime apdEndTime;

    private Integer reNum;


}
