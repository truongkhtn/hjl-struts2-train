package com.company.travel.service;


import com.company.travel.entity.Message;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
public interface MessageService extends BaseService<Message, String>{
    void sendToAll(Message message);

    void sendToGroups(Message message, String[] ids);
}