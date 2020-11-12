package com.woniuxy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class LimoBannerDto implements Serializable {


    private Integer id;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 0.首页广告，1 活动 2美食 3旅游指南
     */
    private Integer type;

    private Integer lianId;

    private Integer status;

    private Integer cId;


}
