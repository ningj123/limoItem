package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsParam {
    private Integer pId;
    private Integer aId;
    private Integer num;
    private double price;
    private Integer oId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
