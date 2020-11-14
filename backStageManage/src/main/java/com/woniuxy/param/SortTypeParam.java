package com.woniuxy.param;

import lombok.*;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/11 11:36
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SortTypeParam extends PageParam{
    private String city;
    private Integer cId=-1;
    private String secname;
}
