package com.woniuxy.doman;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class LimoProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;

    private String pName;

    private Integer pInven;

    private Double pOldPrice;

    private Double pNewPrice;

    private Double pSellPrice;

    private String pImages;

    private String pDes;

    /**
     * 0 美食 1 工具 2 房车 3 特色住宿 4 可以售卖的房车
     */
    private Integer pType;

    private Integer urId;

    private Integer cId;

    private Integer pStatus;

    private Integer jId;

    /**
     * 城市字段
     */
    private String cCity;

    private Integer pTwo;


}
