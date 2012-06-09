package com.company.travel.service.impl;

import com.company.travel.dao.GroupDao;
import com.company.travel.dao.MessageDao;
import com.company.travel.dao.MessageLogDao;
import com.company.travel.dao.UserDao;
import com.company.travel.entity.Group;
import com.company.travel.entity.Message;
import com.company.travel.entity.MessageLog;
import com.company.travel.entity.User;
import com.company.travel.service.MessageService;
import com.company.travel.utils.MyConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Service
@Transactional
public class MessageServiceImpl extends BaseServiceImpl<Message, String> implements MessageService {

    private static final Logger log = Logger.getLogger(MessageServiceImpl.class);

    @Resource
    public void setBaseDao(MessageDao messageDao) {
        super.setBaseDao(messageDao);
    }

    @Resource
    private MessageDao messageDao;
    @Resource
    private MessageLogDao messageLogDao;
    @Resource
    private UserDao userDao;
    @Resource
    private GroupDao groupDao;


    public void sendToAll(Message message) {
        List<User> userList = userDao.getAllNotAdmin();
        saveMessageLogToUserList(message, userList);
    }

    private void saveMessageLogToUserList(Message message, List<User> userList) {
        messageDao.save(message);
        for (User user : userList) {
            MessageLog log = new MessageLog();
            log.setMessage(message);
            log.setUser(user);
            log.setReadStatus(MyConstant.UNREAD);
            messageLogDao.save(log);
        }
    }

    public void sendToGroups(Message message, String[] ids) {
        List<User> userList = new ArrayList<User>();
        String sGroups = "";
        for (String id : ids) {
            Group group = groupDao.get(id);
            Set<User> userSet = group.getUserSet();
            for (User u : userSet) {
                userList.add(u);
            }
            String name = group.getName();
            sGroups += name + ",";
        }
        log.debug("sGroups 1:" + sGroups);
        sGroups = sGroups.substring(0, sGroups.length() - 1);
        message.setGroups(sGroups);
        log.debug("sGroups 2:" + sGroups);
        log.info("sendToUsers:" + userList.size());
        saveMessageLogToUserList(message, userList);
    }
}
