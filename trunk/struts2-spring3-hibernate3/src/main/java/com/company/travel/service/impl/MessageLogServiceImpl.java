package com.company.travel.service.impl;

import com.company.travel.dao.BaseDao;
import com.company.travel.dao.MessageLogDao;
import com.company.travel.entity.MessageLog;
import com.company.travel.service.MessageLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Service
@Transactional
public class MessageLogServiceImpl extends BaseServiceImpl<MessageLog , String> implements MessageLogService {

    @Resource
    public void setBaseDao(MessageLogDao messageLogDao) {
        super.setBaseDao(messageLogDao);
    }

    @Resource
    private MessageLogDao messageLogDao;

    public List<MessageLog> getByUserId(String userId) {
        return messageLogDao.getByUserId(userId);
    }
}
