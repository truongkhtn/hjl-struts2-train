package com.company.travel.service.impl;

import com.company.travel.dao.CompanyInfoDao;
import com.company.travel.dao.RouteDao;
import com.company.travel.entity.CompanyInfo;
import com.company.travel.service.CompanyInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RouteServiceImpl
 */
@Service
@Transactional
public class CompanyInfoServiceImpl extends BaseServiceImpl<CompanyInfo, String> implements CompanyInfoService {

    @Resource
    public void setBaseDao(CompanyInfoDao companyInfoDao) {
        super.setBaseDao(companyInfoDao);
    }
}
