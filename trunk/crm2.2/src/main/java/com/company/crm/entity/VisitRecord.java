package com.company.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * 拜访记录类
 */
@Entity
@Table(name="tbl_visit_record")
public class VisitRecord extends BaseEntity {
	
	private static final long serialVersionUID = 8890362439270172552L;
	private User user;//客户专员名
	private Date visitDate;//拜访日期
	private Customer customer; //客户
	private VisitType visitType;//拜访方式
	private Contact contact;//联系人
	private boolean isFirstVisit; //是否是第一次拜访
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	@ManyToOne
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@OneToOne
	@JoinColumn(name="visit_type_id")
	public VisitType getVisitType() {
		return visitType;
	}
	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}
	@ManyToOne
	@JoinColumn(name="contractor_id")
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public boolean isFirstVisit() {
		return isFirstVisit;
	}
	public void setFirstVisit(boolean isFirstVisit) {
		this.isFirstVisit = isFirstVisit;
	}
	
}
