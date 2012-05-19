package com.company.travel.service.impl;

import com.company.travel.dao.ResourceDao;
import com.company.travel.entity.Resource;
import com.company.travel.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResourceServiceImpl extends BaseServiceImpl<Resource, String> implements ResourceService {

    @javax.annotation.Resource
    public void setBaseDao(ResourceDao resourceDao) {
        super.setBaseDao(resourceDao);
    }
}
