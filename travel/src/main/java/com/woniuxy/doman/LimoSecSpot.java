package com.woniuxy.doman;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class LimoSecSpot implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sec_id", type = IdType.AUTO)
    private Integer secId;

    private String secSportName;

    private String secSportAddress;

    private String secSportCity;

    private Integer cId;

    private String cName;

    private String secSportOpentime;

    private String secSportServer;

    private String secSportImgurl;

    private Double secSportPrice;


}
