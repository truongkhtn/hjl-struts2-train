package com.company.crm.entity;

import java.util.Set;

import javax.persistence.*;

/**
 *   客户 实体类
 */
@Entity
@Table(name="tbl_customer")
public class Customer extends BaseEntity{
	
	private static final long serialVersionUID = -1634517509763085662L;
	public enum Status{
        UNSIGNED,
        SIGNED,
        SEA
	}
	
	public enum Source{
		VISIT, //上门拜访
		WEB_SEARCH, //网络搜索
		YELLOW_PAGE,  //企业黄页
        INTRODUCE,  //转介绍
		WALK_IN    //客户来访
	}

    public enum Level{
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }

	private String name;//客户名
	private String address; //地址
	private String address2; //其他地址
	private Level level;//信用等级
	private Source source;//客户来源
	private String fax;//传真号
	private String webSite;//网站
	private String business;//客户行业
	private String remark;//客户描述
	private Status status;//签约与否
	private Set<VisitRecord> visitRecodeSet;//拜访记录
	private User user;//客户所属用户

    private Contact majorContact; //主联系人

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
    @Enumerated(EnumType.STRING)
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    @Enumerated(EnumType.STRING)
    public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    @Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL})
	public Set<VisitRecord> getVisitRecodeSet() {
		return visitRecodeSet;
	}
	public void setVisitRecodeSet(Set<VisitRecord> visitRecodeSet) {
		this.visitRecodeSet = visitRecodeSet;
	}
    @Transient
     public Contact getMajorContact() {
        return majorContact;
    }
    public void setMajorContact(Contact majorContact) {
        this.majorContact = majorContact;
    }
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
