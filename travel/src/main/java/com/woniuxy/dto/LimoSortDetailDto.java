package com.woniuxy.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LimoSortDetailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "so_d_id", type = IdType.AUTO)
    private Integer soDId;

    private String soDName;

    private String soDDes;

    private List soDImages;

    private LocalDateTime soDIssueTime;

    /**
     * 0 热门 1 营地 2 美食 3 景区
     */
    private Integer soDType;

    private String soDCity;

    private Integer soId;

    /**
     * 0 开放 1 不开放
     */
    private Integer soDStatus;

    private String soDKeyword;

    private Integer soDTwo;


}
