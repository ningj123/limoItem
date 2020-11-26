package com.woniuxy.param;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/25 17:49
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppParam {
   private int hid;
   private String name;
   private int num;
   private int cid;
   private String phone;
   private String card;
   private double price;
   private String starttime;
   private String endtime;

}
