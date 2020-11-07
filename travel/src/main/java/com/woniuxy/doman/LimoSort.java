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
 * @since 2020-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "so_id", type = IdType.AUTO)
    private Integer soId;

    private String soName;


}
