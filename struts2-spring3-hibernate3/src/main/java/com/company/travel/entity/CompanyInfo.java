package com.company.travel.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 实体类 - 旅游线路,如：黄山2日游,黄山3日游
 * 一个 Route 包含多个 Journey
 */
@Entity
@Table(name="tbl_companyInfo")
public class CompanyInfo extends BaseEntity{

	// 台州负责人
	private String principal;
	// 台州计调
	private String allocateUser;
	// 联系电话
	private String contactTel;
	// 传真
	private String fax;
	// QQ
	private String qq;
	// E-Mail
	private String eMail;
    //集合-行程
    private List<CompanyAccount> companyAccountList;

    //constructors
    public CompanyInfo() {
    }

    public String getAllocateUser() {
        return allocateUser;
    }

    public void setAllocateUser(String allocateUser) {
        this.allocateUser = allocateUser;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @OneToMany(targetEntity= CompanyAccount.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="companyID")
	@OrderBy("seq asc")
    public List<CompanyAccount> getCompanyAccountList() {
        return companyAccountList;
    }

    public void setCompanyAccountList(List<CompanyAccount> companyAccountList) {
        this.companyAccountList = companyAccountList;
    }
}
