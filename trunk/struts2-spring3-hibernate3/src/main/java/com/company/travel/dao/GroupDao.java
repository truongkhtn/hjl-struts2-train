package com.company.travel.dao;

import com.company.travel.entity.Group;
import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.User;

import java.util.List;

/**
 * GroupDao 接口类
 */
public interface GroupDao extends BaseDao<Group , String>{
    List<MessageCategory> getAllBySeq();

    List<User> getUserByGroup(String id);
}
