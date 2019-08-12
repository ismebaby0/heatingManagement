package com.neusoft.ht.complain.model;


import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/*
 *   投诉类型 model 
 *   作者: 方俊坤
 */
public class ComplainType implements Serializable{
    private Integer typeNo;

    private String typeName;

    public Integer getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}