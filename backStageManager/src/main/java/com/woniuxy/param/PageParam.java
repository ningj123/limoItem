package com.woniuxy.param;

import lombok.*;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/24 19:47
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageParam {
    private Integer pageSize;
    private Integer pageNum;
}
