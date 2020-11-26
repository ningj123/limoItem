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
public class LimoCollectParam {
    private Integer coId;

    private Integer pId;

    private Integer uId;

    private Integer cId;

    private Integer aId;

    private Integer coType;

    private LocalDateTime coTime;

}
