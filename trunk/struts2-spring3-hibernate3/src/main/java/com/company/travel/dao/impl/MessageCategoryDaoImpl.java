package com.company.travel.dao.impl;

import com.company.travel.dao.MessageCategoryDao;
import com.company.travel.entity.MessageCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MessageCategoryDao 实现类
 */
@Repository
public class MessageCategoryDaoImpl extends BaseDaoImpl<MessageCategory, String> implements MessageCategoryDao {
    public List<MessageCategory> getAllBySeq() {
        String hql = "from MessageCategory mc order by seq asc";
        return getSession().createQuery(hql).list();
    }
}
