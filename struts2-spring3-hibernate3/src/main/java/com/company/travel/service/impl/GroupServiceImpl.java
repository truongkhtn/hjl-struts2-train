package com.company.travel.service.impl;

import com.company.travel.dao.GroupDao;
import com.company.travel.entity.Group;
import com.company.travel.entity.MessageCategory;
import com.company.travel.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * GroupService 接口实现类
 */
@Service
@Transactional
public class GroupServiceImpl extends BaseServiceImpl<Group  , String> implements GroupService{

    @Resource
    public void setBaseDao(GroupDao groupDao) {
        super.setBaseDao(groupDao);
    }

    @Resource
    private GroupDao groupDao;

    public List<MessageCategory> getAllBySeq() {
       return groupDao.getAllBySeq();
    }
}
