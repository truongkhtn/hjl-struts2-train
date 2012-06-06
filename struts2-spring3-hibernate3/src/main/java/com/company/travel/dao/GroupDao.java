package com.company.travel.dao;

import com.company.travel.entity.Group;
import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.User;

import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
public interface GroupDao extends BaseDao<Group , String>{
    List<MessageCategory> getAllBySeq();

    List<User> getUserByGroup(String id);
}
