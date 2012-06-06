package com.company.travel.service.impl;

import com.company.travel.dao.BaseDao;
import com.company.travel.dao.MessageCategoryDao;
import com.company.travel.dao.UserDao;
import com.company.travel.entity.MessageCategory;
import com.company.travel.service.BaseService;
import com.company.travel.service.MessageCategoryService;
import com.sun.tools.internal.ws.wsdl.document.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Service
@Transactional
public class MessageCategoryServiceImpl extends BaseServiceImpl<MessageCategory, String> implements MessageCategoryService{

    @Resource
    public void setBaseDao(MessageCategoryDao messageCategoryDao) {
        super.setBaseDao(messageCategoryDao);
    }

    @Resource
    private MessageCategoryDao messageCategoryDao;

    public List<MessageCategory> getAllBySeq() {
       return messageCategoryDao.getAllBySeq();
    }
}
