package com.woniuxy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LimoCampDto implements Serializable {


    private Integer cId;

    private String cName;

    private String cAddress;

    private String cPhone;

    private String cOpenTime;

    private String cSpecial;

    private String cCity;

    private String cDes;

    private String cImages;

    /**
     * 0正常，1不正常
     */
    private Integer cStatus;

    private Integer jId;

    private String cOne;

    private Integer mId;


}
