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
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimoSecSpotDto implements Serializable {

    private static final long serialVersionUID = 1L;


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
