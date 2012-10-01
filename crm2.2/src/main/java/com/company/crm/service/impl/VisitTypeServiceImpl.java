package com.company.crm.service.impl;

import com.company.crm.dao.VisitTypeDao;
import com.company.crm.entity.VisitType;
import com.company.crm.service.VisitTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisitTypeServiceImpl extends BaseServiceImpl<VisitType , String> implements VisitTypeService{

    @Resource
    private VisitTypeDao visitTypeDao;

    @Resource
    public void setBaseDao(VisitTypeDao visitTypeDao){
        super.setBaseDao(visitTypeDao);
    }

}
