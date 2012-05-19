package com.company.travel.service.impl;

import com.company.travel.dao.BaseDao;
import com.company.travel.dao.MessageDao;
import com.company.travel.service.MessageService;
import com.sun.tools.internal.ws.processor.model.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Service
@Transactional
public class MessageServiceImpl extends BaseServiceImpl<Message , String> implements MessageService{

    @Resource
    public void setBaseDao(MessageDao messageDao) {
        super.setBaseDao(messageDao);
    }
}
