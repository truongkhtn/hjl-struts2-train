package com.company.crm.action;

import java.util.List;

/**
 * 分页 类， 用于实现分页功能
 */
public class Pager {

    // 排序方式
    public enum OrderType {
        asc, //正序
        desc //倒序
    }

    public static final Integer MAX_PAGE_SIZE = 500;// 每页最大记录数限制

	private Integer pageNumber = 1;// 当前页码，初始值1
	private Integer pageSize = 15;// 每页记录数, 初始值15
	private Integer totalCount = 0;// 总记录数，初始值0
	private Integer pageCount = 0;// 总页数， 初始值0
    private String property;// 查找属性名称
	private String keyword;// 查找关键字
	private List list;// 数据List，用于存放分页数据

    //constructor
    public Pager() {
    }

    public Pager(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //getter & setter
    public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		if (pageNumber < 1) {
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

    public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		} else if(pageSize > MAX_PAGE_SIZE) {
			pageSize = MAX_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

    public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

    public Integer getPageCount() {
		pageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			pageCount ++;
		}
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

    public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
