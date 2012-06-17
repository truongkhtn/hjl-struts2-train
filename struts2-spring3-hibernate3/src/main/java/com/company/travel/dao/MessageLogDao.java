package com.company.travel.dao;

import com.company.travel.entity.MessageLog;

import java.util.List;

/**
 * MessageLogDao 接口类
 */
public interface MessageLogDao extends BaseDao<MessageLog, String>{
    List<MessageLog> getByUserId(String userId);
}
