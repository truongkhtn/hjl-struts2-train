package com.company.travel.dao.impl;

import com.company.travel.dao.MessageDao;
import com.company.travel.entity.Message;
import org.springframework.stereotype.Repository;

/**
 * MessageDao 实现类
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message, String> implements MessageDao {

}
