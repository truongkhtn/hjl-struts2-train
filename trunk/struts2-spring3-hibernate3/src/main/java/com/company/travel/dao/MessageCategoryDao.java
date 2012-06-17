package com.company.travel.dao;

import com.company.travel.entity.MessageCategory;

import java.util.List;

/**
 * MessageCategoryDao 接口类
 */
public interface MessageCategoryDao extends BaseDao<MessageCategory , String>{
    List<MessageCategory> getAllBySeq();

}
