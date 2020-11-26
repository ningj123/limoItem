package com.woniuxy.param;

import lombok.*;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/25 14:44
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailParam {
    private String name;
    private Integer cid;
}
