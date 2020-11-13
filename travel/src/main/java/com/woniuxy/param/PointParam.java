package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuli
 * @description: 地方经纬度
 * @date: 2020/11/12 15:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointParam {
    //经度
    private  Float precision;
    //纬度
    private  Float dimension;

    private Integer distance;
}
