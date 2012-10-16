package com.company.crm.service;

import com.company.crm.action.Pager;
import com.company.crm.entity.Contact;
import com.company.crm.entity.User;

import java.util.List;

public interface ContactService extends BaseService<Contact, String>{
	
	/**
	 * 根据公司id查找联系人
	 * @param id
	 * @return
	 */
	List<Contact> getByCustomerId(String id);

    /**
	 * 根据公司id查找主联系人
	 * @param id
	 * @return
	 */
    Contact getMajorByCustomerId(String id);

    /**
     * 根据联系人信息，查询客户信息，用于客户冲突功能
     * @param pager  分页
     * @param contact  联系人信息
     * @return 分页
     */
    Pager getByPager(Pager pager, Contact contact);

    /**
     * 根据客户专员，查询客户列表，用户显示服务中客户列表
     * @param pager 分页
     * @param owner 客户专员
     * @return 分页
     */
    Pager getServeByUser(Pager pager, User owner);
}
