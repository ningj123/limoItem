package com.woniuxy.param;

import lombok.*;

import java.security.PrivateKey;

/**
 * @author zhuyuli
 * @description: 类别查询参数
 * @date: 2020/11/10 9:46
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeParam extends PageParam{
    private Integer type;
    private String keyWord;
}
