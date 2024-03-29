package com.company.travel.controller;

/**
 * BasePager 基类，具有分页功能
 */
public class BasePagerAction extends BaseAction {

    public static final String PAGE_NUMBER = "pageNumber"; //当前页码
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
