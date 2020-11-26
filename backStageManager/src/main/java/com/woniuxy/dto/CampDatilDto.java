package com.woniuxy.dto;

import lombok.*;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/25 10:09
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampDatilDto {

    private Integer hId;

    private String hName;

    private Double hPrice;

    private String hImages;

    private String hDes;

    /**
     * 1 房车 2 特色住宿 3 可售卖的房车
     */
    private Integer hType;

    private Integer cId;

    private String cname;

    private Integer hStatus;
}
