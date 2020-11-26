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
public class OrderDetailParam {
    private Integer oId;
    private LocalDateTime oTime;
    private Integer oStatus;
    private Double oTotal;
    private Integer cId;
    private Integer aId;
    private Integer pId;
    private Integer pNum;
    private Double pPrice;
    private Integer orId;
}
