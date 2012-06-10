package com.company.travel.dao.impl;

import com.company.travel.dao.MessageLogDao;
import com.company.travel.entity.MessageLog;
import com.company.travel.utils.MyConstant;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Repository
public class MessageLogDaoImpl extends BaseDaoImpl<MessageLog, String> implements MessageLogDao {
    public List<MessageLog> getByUserId(String userId) {
//        String hql = "from MessageLog log where log.user.id=? and log.readStatus=? order by log.createDate desc";
//        return getSession().createQuery(hql).setParameter(0, userId).setParameter(1, MyConstant.UNREAD).list();
        String hql = "from MessageLog log where log.user.id=? order by log.createDate desc";
        return getSession().createQuery(hql).setParameter(0, userId).list();
    }
}
