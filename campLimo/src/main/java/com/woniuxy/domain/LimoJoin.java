package com.woniuxy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * limo_join
 * @author 
 */
@Data
public class LimoJoin implements Serializable {
    private Integer jId;

    /**
     * 所属人
     */
    private String jName;

    private String jPhone;

    private String jSerail;

    private String jLimoAddress;

    private String jLimoType;

    private Integer cId;

    private String jCardImages;

    private String jLimoImages;

    private Date jStartTime;

    private Date jEndTime;

    private Integer jType;

    private String jEmail;

    private String jRemark;

    /**
     * 营地名称
     */
    private String jCampName;

    /**
     * 0 加盟申请状态  1同意申请   2拒绝申请
     */
    private Integer jStatus;

    private static final long serialVersionUID = 1L;
}