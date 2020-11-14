package com.woniuxy.param;

import lombok.*;

/**
 * @author zhuyuli
 * @description: 周边景点参数
 * @date: 2020/11/10 15:51
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SortParam extends PageParam{
    private Integer id;

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
