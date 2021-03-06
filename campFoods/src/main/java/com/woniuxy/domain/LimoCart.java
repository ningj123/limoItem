package com.woniuxy.domain;

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
 * @author lx
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ca_id", type = IdType.AUTO)
    private Integer caId;

    private Integer pId;

    private Integer aId;

    private Integer pNum;

    private Integer caType;

    private Integer uId;

    private Integer caStatus;


}
