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

    private LocalDateTime apTime;

    private Integer apStatus;

    private Double apTotal;

    private Integer cId;

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
     * 入住人数
     */
    private Integer apNum;


}
