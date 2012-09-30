package com.company.crm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_visit_type")
public class VisitType extends BaseEntity{

	private static final long serialVersionUID = -7175971357033853874L;
	private String name;
	private boolean status;//是否有效
	private int req;  //排序需要
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getReq() {
		return req;
	}
	public void setReq(int req) {
		this.req = req;
	}
	
}
