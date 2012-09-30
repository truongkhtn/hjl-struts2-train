package com.company.crm.service.impl;

import com.company.crm.dao.RoleDao;
import com.company.crm.dao.UserDao;
import com.company.crm.entity.Role;
import com.company.crm.service.BaseService;
import com.company.crm.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Resource
    public void setBaseDao(RoleDao roleDao) {
        super.setBaseDao(roleDao);
    }
}
