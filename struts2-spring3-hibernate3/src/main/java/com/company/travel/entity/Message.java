package com.company.travel.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 实体类 - 消息
 */
@Entity
@Table(name = "tbl_message")
public class Message extends BaseEntity{

    private String title; //主题
    private Date date; //日期
    private String category; //分类
    private String content; //内容

    private Set<MessageLog> messageLogs;

    public Message() {
    }

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "message")
    @OrderBy("seq asc")
    public Set<MessageLog> getMessageLogs() {
        return messageLogs;
    }

    public void setMessageLogs(Set<MessageLog> messageLogs) {
        this.messageLogs = messageLogs;
    }

    @Column(nullable = false , length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
