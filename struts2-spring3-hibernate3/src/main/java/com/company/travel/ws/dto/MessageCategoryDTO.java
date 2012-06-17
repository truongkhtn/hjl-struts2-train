package com.company.travel.ws.dto;

import javax.xml.bind.annotation.XmlType;

/**
 * WebService 消息分类返回对象
 */
@XmlType(propOrder = {
    "id","name","seq"
})
public class MessageCategoryDTO {

    private String id;//主键
    private String name; //名称
    private int seq; //排序

    public MessageCategoryDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
