package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersParam {
    private Integer uId;
    private Integer cId;
    private Integer urId;
    private double total;
    private List<OrderDetailsParam> orderDetailsParams;
}
