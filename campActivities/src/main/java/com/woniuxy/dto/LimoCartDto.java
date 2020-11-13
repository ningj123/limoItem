package com.woniuxy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimoCartDto {
    private Integer caId;

    private String pId;

    private Integer aId;

    private Integer pNum;

    private Integer caType;

    private Integer uId;
}
