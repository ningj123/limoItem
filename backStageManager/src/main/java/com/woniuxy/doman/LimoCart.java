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
public class LimoCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ca_id", type = IdType.AUTO)
    private Integer caId;

    private Integer pId;

    private Integer aId;

    private Integer pNum;

    private Integer caType;

    private Integer uId;

    /**
     * 0正常，1删除
     */
    private Integer caStatus;


}
