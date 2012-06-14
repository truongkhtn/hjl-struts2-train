package com.company.travel.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息列表返回对象
 */
@XmlRootElement
@XmlType(propOrder = {  "messageCategoryList" })
public class MessageCategoryListDTO {

    private List<MessageCategoryDTO> messageCategoryList;//消息分类列表

    public MessageCategoryListDTO() {
    }

    public List<MessageCategoryDTO> getMessageCategoryList() {
        if(messageCategoryList == null){
            messageCategoryList = new ArrayList<MessageCategoryDTO>();
        }
        return messageCategoryList;
    }

    public void setMessageCategoryList(List<MessageCategoryDTO> messageCategoryList) {
        this.messageCategoryList = messageCategoryList;
    }
}
