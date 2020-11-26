package com.woniuxy.param;

import lombok.*;

import java.util.List;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/25 15:00
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SleepParam {
    private int id;
    private int cid;
    private int hid;
    private int apid;
    private List<Per> list;

}
