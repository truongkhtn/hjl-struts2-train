package com.company.travel.dao.impl;

import com.company.travel.dao.MessageCategoryDao;
import com.company.travel.entity.MessageCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Repository
public class MessageCategoryDaoImpl extends BaseDaoImpl<MessageCategory, String> implements MessageCategoryDao {
    public List<MessageCategory> getAllBySeq() {
        String hql = "from MessageCategory mc order by seq asc";
        return getSession().createQuery(hql).list();
    }
}
