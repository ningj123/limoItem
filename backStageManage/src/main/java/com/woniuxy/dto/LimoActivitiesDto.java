package com.woniuxy.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName LimoActivitiesDto
 * @Author shadow
 * @Date 2020/11/13 14:31
 * @Description TODO
 **/
public class LimoActivitiesDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cId;
    private String cName;
    private List<LimoActivityDto> list;

    public LimoActivitiesDto(Integer cId, String cName, List<LimoActivityDto> list) {
        this.cId = cId;
        this.cName = cName;
        this.list = list;
    }

    public LimoActivitiesDto() {
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<LimoActivityDto> getList() {
        return list;
    }

    public void setList(List<LimoActivityDto> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LimoActivitiesDto{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", list=" + list +
                '}';
    }
}
