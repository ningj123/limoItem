package com.woniuxy.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName LimoJoinsDto
 * @Author shadow
 * @Date 2020/11/13 11:54
 * @Description TODO
 **/
public class LimoJoinsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cId;
    private String cName;
    private List<LimoJoinDto> list;

    public LimoJoinsDto() {
    }

    public LimoJoinsDto(Integer cId, String cName, List<LimoJoinDto> list) {
        this.cId = cId;
        this.cName = cName;
        this.list = list;
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

    public List<LimoJoinDto> getList() {
        return list;
    }

    public void setList(List<LimoJoinDto> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LimoJoinsDto{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", list=" + list +
                '}';
    }
}
