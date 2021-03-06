package com.woniuxy.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimoActivityDto {
    private Integer aId;

    private String aName;

    /**
     * 库存
     */
    private Integer aInven;

    private String aImages;

    private String aDes;

    private Double aPrice;

    /**
     * 0 音乐 1 旅游 2 美食
     */
    private Integer aType;

    private Integer aSellNum;

    private LocalDateTime aSellTime;

    private LocalDateTime aStartTime;

    private LocalDateTime aEndTime;

    /**
     * 营地ID
     */
    private Integer cId;

    /**
     * 0 正在出售 1 停止出售
     */
    private Integer aStatus;

    /**
     * 传过来的城市
     */
    private String aCity;

    private Integer aTwo;

    private Integer pageIndex;
    private Integer pageNumber;

}
