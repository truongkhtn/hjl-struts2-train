package com.company.travel.ws.dto;

import javax.xml.bind.annotation.XmlType;

/**
 * WebService 消息返回对象
 */
@XmlType(propOrder = {
    "logId","title","category","categorySeq","readStatus","date","content"
})
public class MessageDTO {

    private String logId; //消息记录主键
    private String title; //主题
    private String category;//类别
    private int categorySeq;//类别排序号
    private String readStatus; //是否已读
    private String date; //日期
    private String content; //内容

    public MessageDTO() {
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "logId='" + logId + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", categorySeq=" + categorySeq +
                ", readStatus='" + readStatus + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategorySeq() {
        return categorySeq;
    }

    public void setCategorySeq(int categorySeq) {
        this.categorySeq = categorySeq;
    }
}
