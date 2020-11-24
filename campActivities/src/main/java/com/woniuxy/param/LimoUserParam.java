package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimoUserParam {
    private Integer uId;

    private String uName;
    @NotNull(message = "密码不能为空")
    private String uPassword;

    private String uEmail;
    @NotNull(message = "电话不能为空")
    @Length(min = 11,max = 11,message = "长度只能为11位")
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
