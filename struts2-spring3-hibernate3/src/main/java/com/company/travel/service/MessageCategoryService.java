package com.company.travel.service;

import com.company.travel.entity.MessageCategory;

import java.util.List;

/**
 * MessageCategoryService 接口类
 */
public interface MessageCategoryService extends BaseService<MessageCategory, String >{

    public List<MessageCategory> getAllBySeq();
}
