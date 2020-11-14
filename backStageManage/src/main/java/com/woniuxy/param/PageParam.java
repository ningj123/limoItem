package com.woniuxy.param;

import lombok.*;

/**
 * @author zhuyuli
 * @description: 分页参数
 * @date: 2020/11/10 9:47
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {
    private Integer pageSize;
    private Integer pageNum;
}
