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
public class EvaluateParam {
    private Integer evId;

    private String evDes;

    private String evImages;

    private LocalDateTime evTime;

    /**
     * 活动编号
     */
    private Integer aId;

    private Integer uId;

}
