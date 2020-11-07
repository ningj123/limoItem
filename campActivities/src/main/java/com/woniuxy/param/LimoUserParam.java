package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimoUserParam {
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
