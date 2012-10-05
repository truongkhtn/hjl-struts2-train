package com.company.crm.entity;

import com.company.crm.utils.Level;

import java.util.Date;

import javax.persistence.*;

/*
* 拜访记录类
*/
@Entity
@Table(name="tbl_visit_record")
public class VisitRecord extends BaseEntity {
	
	private static final long serialVersionUID = 8890362439270172552L;
	private Date visitDate;//拜访日期
    private User owner;//客户专员名
    private Customer customer; //客户
	private VisitType visitType;//拜访方式
	private Contact contact;//联系人
    private Level level; //客户成熟度
    private String content; //拜访内容
	private boolean isFirstVisit; //是否是第一次拜访

    @ManyToOne
    @JoinColumn(name = "owner_id")
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
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
	@JoinColumn(name="contact_id")
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Enumerated(EnumType.STRING)
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
}
