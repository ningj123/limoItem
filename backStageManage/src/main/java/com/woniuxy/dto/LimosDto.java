package com.woniuxy.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName LimosDto
 * @Author shadow
 * @Date 2020/11/13 10:09
 * @Description TODO
 **/
public class LimosDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cId;
    private String cName;
    private List<LimoDto> list;

    public LimosDto() {
    }

    public LimosDto(Integer cId, String cName, List<LimoDto> list) {
        this.cId = cId;
        this.cName = cName;
        this.list = list;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<LimoDto> getList() {
        return list;
    }

    public void setList(List<LimoDto> list) {
        this.list = list;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "LimosDto{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", list=" + list +
                '}';
    }
}
