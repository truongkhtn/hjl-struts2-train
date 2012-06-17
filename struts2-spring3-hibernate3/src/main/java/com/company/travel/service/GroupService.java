package com.company.travel.service;

import com.company.travel.entity.Group;

import java.util.List;

/**
 * GroupService 接口类
 */
public interface GroupService extends BaseService<Group , String>{

    List getAllBySeq();
}
