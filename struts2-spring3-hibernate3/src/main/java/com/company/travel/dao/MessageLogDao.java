package com.company.travel.dao;

import com.company.travel.entity.MessageLog;

import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
public interface MessageLogDao extends BaseDao<MessageLog, String>{
    List<MessageLog> getByUserId(String userId);
}
