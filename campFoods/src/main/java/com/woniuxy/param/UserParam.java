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
public class UserParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    private String uName;

    private String uPassword;

    private String uEmail;

    private String uPhone;

    private Integer uAge;

    /**
     * 0 男 1 女
     */
    private Integer uSex;

    /**
     * 0 正常 1 不正常
     */
    private Integer uStatus;

    private LocalDateTime uRegisterTime;

    /**
     * 用户头像
     */
    private String uOne;

    private Integer uTwo;


}
