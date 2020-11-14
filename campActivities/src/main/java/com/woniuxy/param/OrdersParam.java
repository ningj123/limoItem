package com.woniuxy.param;

import com.woniuxy.doman.LimoOrderDetail;
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
    private Integer caId;
    private Integer urId;
    private double total;
    private List<OrderDetailsParam> orderDetailsParams;
}
