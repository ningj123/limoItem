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
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class JoinParam extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "j_id", type = IdType.AUTO)
    private Integer jId;

    /**
     * 所属人
     */
    private String jName;

    private String jPhone;

    private String jSerail;

    private String jLimoAddress;

    private String jLimoType;

    private Integer cId;

    private String jCardImages;

    private String jLimoImages;

    private LocalDateTime jStartTime;

    private LocalDateTime jEndTime;

    private Integer jType;

    private String jEmail;

    private String jRemark;

    /**
     * 营地名称
     */
    private String jCampName;

    /**
     * 0 加盟申请状态  1同意申请   2拒绝申请
     */
    private Integer jStatus;


}
