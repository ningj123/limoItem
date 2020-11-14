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
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoUser implements Serializable {



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
