package com.company.travel.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类 - 消息记录
 */
@Entity
@Table(name = "tbl_message_log")
public class MessageLog extends BaseEntity {

    private Message message; //消息
    private User user; //用户
    private String readStatus; //是否已读
    private int seq; //排序

    public MessageLog() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(nullable = false)
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Column(length = 10)
    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    @Transient
    public boolean getUnRead(){
        return this.readStatus.equals("Unread");
    }

}
