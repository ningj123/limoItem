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
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LimoManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer mId;

    private String mName;

    private String mPhone;

    private String mPassword;

    private String mEmail;

    private Integer rId;


}
