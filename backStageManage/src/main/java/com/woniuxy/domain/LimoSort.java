package com.woniuxy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
public class LimoSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "so_id", type = IdType.AUTO)
    private Integer soId;

    private String soName;


    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName;
    }

    @Override
    public String toString() {
        return "LimoSort{" +
        "soId=" + soId +
        ", soName=" + soName +
        "}";
    }
}
