package com.company.travel.service.impl;

import com.company.travel.dao.MessageCategoryDao;
import com.company.travel.entity.MessageCategory;
import com.company.travel.service.MessageCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * MessageCategoryService 接口实现类
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
