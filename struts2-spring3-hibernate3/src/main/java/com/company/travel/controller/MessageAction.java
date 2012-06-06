package com.company.travel.controller;

import com.company.travel.entity.Message;
import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.User;
import com.company.travel.service.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Message Action 类，包含对于所有 Message 对象的操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class MessageAction extends BaseAction {

    private static final Logger log = Logger.getLogger(MessageAction.class);

    //spring 注入
    @Resource
    private MessageService messageService;
    @Resource
    private MessageCategoryService messageCategoryService;
    @Resource
    private MessageLogService messageLogService;
    @Resource
    private GroupService groupService;

    //action 属性
    private Message message;
    private List messageList;
    private List messageCategoryList;
    private List groupList;
    private Date createDate;
    private String[] ids;
    private String messageCategoryId;

    public String blank() {
        return SUCCESS;
    }

    public String initCreate() {
        messageCategoryList = messageCategoryService.getAllBySeq();
        groupList = groupService.getAllBySeq();
        createDate = new Date();
        return SUCCESS;
    }

    public String messageList() {
        messageList = messageService.getAll();
        return SUCCESS;
    }

    public String view() {
        message = messageService.get(id);
        return SUCCESS;
    }

    public String create() {
        //获取分类
        MessageCategory category = messageCategoryService.get(messageCategoryId);
        //判断发送群体
        boolean send2All = false;
        for (String id : ids) {
            if (id.equals("true")) {
                send2All = true;
                break;
            }
        }
        message.setMessageCategory(category);
        if (send2All) {
            log.info("发送全体");
            message.setGroups("全体");
            messageService.sendToAll(message);
        } else {
            log.info("发送指定群组");
            messageService.sendToGroups(message, ids);
        }
        return SUCCESS;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List getMessageList() {
        return messageList;
    }

    public void setMessageList(List messageList) {
        this.messageList = messageList;
    }

    public List getMessageCategoryList() {
        return messageCategoryList;
    }

    public void setMessageCategoryList(List messageCategoryList) {
        this.messageCategoryList = messageCategoryList;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List getGroupList() {
        return groupList;
    }

    public void setGroupList(List groupList) {
        this.groupList = groupList;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getMessageCategoryId() {
        return messageCategoryId;
    }

    public void setMessageCategoryId(String messageCategoryId) {
        this.messageCategoryId = messageCategoryId;
    }
}
