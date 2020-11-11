package com.woniuxy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    private String aName;

    /**
     * 库存
     */
    private Integer aInven;

    private String aImages;

    private String aDes;

    private Double aPrice;

    /**
     * 0 音乐 1 旅游 2 美食
     */
    private Integer aType;

    private Integer aSellNum;

    private LocalDateTime aSellTime;

    private LocalDateTime aStartTime;

    private LocalDateTime aEndTime;

    /**
     * 营地ID
     */
    private Integer cId;

    /**
     * 0 正在出售 1 停止出售
     */
    private Integer aStatus;

    /**
     * 传过来的城市
     */
    private String aCity;

    private Integer aTwo;


}
