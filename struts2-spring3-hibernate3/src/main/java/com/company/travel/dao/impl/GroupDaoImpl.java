package com.company.travel.dao.impl;

import com.company.travel.dao.GroupDao;
import com.company.travel.entity.Group;
import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Repository
public class GroupDaoImpl extends BaseDaoImpl<Group,String> implements GroupDao{

    public List<MessageCategory> getAllBySeq() {
        String hql = "from Group g order by seq asc";
        return getSession().createQuery(hql).list();
    }

    public List<User> getUserByGroup(String id) {
        Group group = get(id);
        Set<User> userSet = group.getUserSet();
        List<User> userList = new ArrayList<User>();
        for(User u : userSet){
            userList.add(u);
        }
        return userList;
    }
}
