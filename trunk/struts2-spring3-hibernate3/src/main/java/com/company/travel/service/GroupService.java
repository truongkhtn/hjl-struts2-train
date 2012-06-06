package com.company.travel.service;

import com.company.travel.entity.Group;

import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
public interface GroupService extends BaseService<Group , String>{

    List getAllBySeq();
}
