package com.woniuxy.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;


import java.io.Serializable;

/**
 * @author zhuyuli
 * @description: 广告集合参数
 * @date: 2020/11/9 14:13
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BanParam {

    private Integer id;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 0.首页广告，1 活动 2美食 3旅游指南
     */
   // private Integer type;

    private Integer lianId;
}
