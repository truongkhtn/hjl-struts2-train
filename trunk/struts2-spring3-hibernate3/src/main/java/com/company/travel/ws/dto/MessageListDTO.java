package com.company.travel.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * WebService 消息列表返回对象
 */
@XmlRootElement
@XmlType(propOrder = { "unreadNum" , "totalNum" , "messageList" })
public class MessageListDTO {

    private int unreadNum;//未读消息数
    private int totalNum;//总消息数

    private List<MessageDTO> messageList;//消息列表

    public MessageListDTO() {
    }

    public MessageListDTO(int unreadNum,int totalNum, List<MessageDTO> messageList) {
        this.unreadNum = unreadNum;
        this.totalNum = totalNum;
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "MessageListDTO{" +
                "unreadNum=" + unreadNum +
                ", totalNum=" + totalNum +
                ", messageList=" + messageList +
                '}';
    }

    public int getUnreadNum() {
        return unreadNum;
    }

    public void setUnreadNum(int unreadNum) {
        this.unreadNum = unreadNum;
    }

    public List<MessageDTO> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageDTO> messageList) {
        this.messageList = messageList;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
