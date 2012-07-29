package com.company.travel.dao.impl;

import com.company.travel.dao.MessageDao;
import com.company.travel.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MessageDao 实现类
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message, String> implements MessageDao {

    public List<Message> getAllByOrder() {
        String hql = "from Message m order by m.createDate desc";
        return getSession().createQuery(hql).list();
    }
}
