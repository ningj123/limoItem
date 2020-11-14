package com.woniuxy.param;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/7 15:45
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LSDParam implements Serializable {
    private Integer soDId;
    private String soDName;

    private String soDDes;

    private String soDImages;


    /**
     * 0 热门 1 营地 2 美食 3 景区
     */
    private Integer soDType;

    private String soDCity;

    private Integer soId;

    /**
     * 0 开放 1 不开放
     */
    private Integer soDStatus=0;

    private String soDKeyword;
}
