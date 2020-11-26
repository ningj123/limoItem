package com.woniuxy.param;

import lombok.*;

import java.util.List;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/24 20:43
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonParam {
    private int id;
    private List<Per> list;

}
