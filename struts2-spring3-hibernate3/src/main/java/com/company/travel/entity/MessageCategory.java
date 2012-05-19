package com.company.travel.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 实体类 - 消息分类
 */
@Entity
@Table(name = "tbl_message_category")
public class MessageCategory extends BaseEntity{

    private String name; //名称
    private String description; //描述
    private Set<Message> messageSet; //消息
    private int seq; //排序

    public MessageCategory() {
    }

    public MessageCategory(String name , int seq) {
        this.name = name;
        this.seq = seq;
    }

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "messageCategory")
    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }

    @Column(nullable = false , length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = true , length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
