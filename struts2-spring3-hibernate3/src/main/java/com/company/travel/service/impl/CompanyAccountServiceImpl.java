package com.company.travel.service.impl;

import com.company.travel.dao.CompanyAccountDao;
import com.company.travel.entity.CompanyAccount;
import com.company.travel.service.CompanyAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RouteServiceImpl
 */
@Service
@Transactional
public class CompanyAccountServiceImpl extends BaseServiceImpl<CompanyAccount, String> implements CompanyAccountService {

    @Resource
    public void setBaseDao(CompanyAccountDao companyAccountDao) {
        super.setBaseDao(companyAccountDao);
    }
}
