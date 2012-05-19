package com.company.travel.controller;

import com.company.travel.entity.User;
import com.company.travel.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * BasePager 基类，具有分页功能
 *
 * @author 胡荆陵
 */
public class BasePagerAction extends BaseAction {

    public static final String PAGE_NUMBER = "pageNumber"; //当前页码
//	public static final String TOTAL_COUNT = "totalCount";  //总记录数
	public static final String PAGE_COUNT = "pageCount";  //总页数

    protected Pager pager;

    //getter & setter
    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
