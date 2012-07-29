package com.company.travel.dao;


import com.company.travel.entity.Message;

import java.util.List;

/**
 * MessageDao 接口类
 */
public interface MessageDao extends BaseDao<Message, String>{

    public List<Message> getAllByOrder();
}
