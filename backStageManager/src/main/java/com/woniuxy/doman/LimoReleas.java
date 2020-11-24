package com.woniuxy.doman;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoReleas implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 上架编号商品
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编号
     */
    private Integer pId;

    /**
     * 上架人员编号
     */
    private Integer mId;

    /**
     * 上架商品数量
     */
    private Integer number;

    /**
     * 商品上架时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 商品下架时间
     */
    @TableField("overTime")
    private LocalDateTime overTime;

    /**
     * 原价
     */
    private Double oldPrice;

    /**
     * 现价
     */
    private Double newPrice;

    /**
     * 已售卖数量
     */
    private Integer buyNumber;

    /**
     * 上架商品状态 0上架，1下架
     */
    private Integer status;

    /**
     * 上架商品类型 0美食 1物资
     */
    private Integer pType;

    /**
     * 营地编号
     */
    @TableField("cId")
    private Integer cId;

    /**
     * 营地所属城市
     */
    private String city;


}
