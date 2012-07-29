package com.company.travel.service;


import com.company.travel.entity.Message;

import java.util.List;

/**
 * MessageService 接口类
 */
public interface MessageService extends BaseService<Message, String>{

    public List<Message> getAllByOrder();

    void sendToAll(Message message);

    void sendToGroups(Message message, String[] ids);
}
