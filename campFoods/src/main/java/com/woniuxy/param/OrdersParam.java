package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersParam implements Serializable {
    private Integer uId;
    private Integer cId;
    private Integer caId;
    private Integer urId;
    private double total;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<ProductParam> product;
}
