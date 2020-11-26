package com.woniuxy.param;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LimoAppointParam implements Serializable {



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
     * 0预约 1使用 2完成
     */
    //private Integer apStatus;


}
