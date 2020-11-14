package com.woniuxy.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimoCityParam {



    private Integer id;

    private String city;

    private String cityUrl;

    private Integer tatol=0;

}
