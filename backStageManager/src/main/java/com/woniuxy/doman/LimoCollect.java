package com.woniuxy.doman;

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
 * @author zhuyuli
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoCollect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "co_id", type = IdType.AUTO)
    private Integer coId;

    private Integer pId;

    private Integer uId;

    private Integer cId;

    private Integer aId;

    private Integer coType;

    private LocalDateTime coTime;


}
