package com.company.crm.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role extends BaseEntity{

	private static final long serialVersionUID = 7690574995629823045L;
	
	private String roleName;//角色的名称
	private String remark; //角色的描述
	private Set<User> userSet;//一个角色包涵多个用户
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@ManyToMany(mappedBy="roleSet")
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
