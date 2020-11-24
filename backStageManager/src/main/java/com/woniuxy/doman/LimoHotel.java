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
public class LimoHotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "h_id", type = IdType.AUTO)
    private Integer hId;

    private String hName;

    private Double hPrice;

    private String hImages;

    private String hDes;

    /**
     * 1 房车 2 特色住宿 3 可售卖的房车
     */
    private Integer hType;

    private Integer cId;

    private Integer hStatus;


}
