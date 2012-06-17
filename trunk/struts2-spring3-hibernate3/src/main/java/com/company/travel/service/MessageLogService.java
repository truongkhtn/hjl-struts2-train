package com.company.travel.service;

import com.company.travel.entity.MessageLog;

import java.util.List;

/**
 * MessageLogService 接口类
 */
public interface MessageLogService extends BaseService<MessageLog, String> {
    List<MessageLog> getByUserId(String userId);
}
