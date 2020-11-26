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
public class LimoAppoint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ap_id", type = IdType.AUTO)
    private Integer apId;

    private Integer cId;

    private Integer hId;

    private LocalDateTime orStartTime;

    private LocalDateTime orEndTime;

    private Integer uId;

    /**
     * 联系人姓名
     */
    private String reName;

    /**
     * 联系人电话
     */
    private String rePhone;

    /**
     * 几人住宿
     */
    private Integer reNum;

    /**
     * 0 待付款 1 预约成功 2 预约失败
     */
    private Integer apStatus;


}
