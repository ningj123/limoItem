package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimoActivityVoParam {
    private String aCity;
    @NotNull(message = "页码不能为空")
    private Integer pageIndex;
}
