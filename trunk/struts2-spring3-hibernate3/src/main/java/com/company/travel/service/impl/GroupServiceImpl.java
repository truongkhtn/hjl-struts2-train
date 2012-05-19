package com.company.travel.service.impl;

import com.company.travel.dao.BaseDao;
import com.company.travel.dao.GroupDao;
import com.company.travel.entity.Group;
import com.company.travel.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@Service
@Transactional
public class GroupServiceImpl extends BaseServiceImpl<Group  , String> implements GroupService{

    @Resource
    public void setBaseDao(GroupDao groupDao) {
        super.setBaseDao(groupDao);
    }
}
