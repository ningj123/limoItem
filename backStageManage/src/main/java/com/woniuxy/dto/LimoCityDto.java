package com.woniuxy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class LimoCityDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String city;

    private String cityUrl;

    private Integer tatol;


}
