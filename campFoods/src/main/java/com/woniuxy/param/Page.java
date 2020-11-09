package com.woniuxy.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private Integer pageSize;
    private Integer pageNum;
}
