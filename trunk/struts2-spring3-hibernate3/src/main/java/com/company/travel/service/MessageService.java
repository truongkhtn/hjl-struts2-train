package com.company.travel.service;


import com.company.travel.entity.Message;

/**
 * MessageService 接口类
 */
public interface MessageService extends BaseService<Message, String>{
    void sendToAll(Message message);

    void sendToGroups(Message message, String[] ids);
}
