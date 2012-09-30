package com.company.crm.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="tbl_user")
public class User extends BaseEntity{
	
	private static final long serialVersionUID = -4363594553250848418L;
	public enum Gender{
		MALE,
		FEMALE
	}
	private String empNo;//员工工号
	private int maxCustomer;//最多客户
	private Date birthDate;//员工生日
	private String telephone;//联系电话
	private Gender gender;//员工性别
	private String username;//系统登录用户名
	private String password;//系统用户的登录密码
	private String realName;//用户真实姓名
	private Department dept;//用户所属部门
	private String remarks;//备注
	private Set<Role> roleSet;//一个用户可以拥有多个角色
	private boolean status;//该用户账号的状态

    @Column(unique = true, nullable = false)
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public int getMaxCustomer() {
		return maxCustomer;
	}
	public void setMaxCustomer(int maxCustomer) {
		this.maxCustomer = maxCustomer;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    @Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="tbl_user_to_role")
	public Set<Role> getRoleSet() {
        if(roleSet == null){
            roleSet = new HashSet<Role>();
        }
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name="dept_id")
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

}
