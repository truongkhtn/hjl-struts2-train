package com.company.crm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tbl_department")
public class Department extends BaseEntity{
	
	private static final long serialVersionUID = 4735907212206380861L;
	
	private String deptName;//部门名称
	private Department parent;//父部门
	private Set<Department> children;//子部门
	private Set<User> user;//部门所属员工

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@ManyToOne
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent",cascade={CascadeType.ALL})
	public Set<Department> getChildren() {
		return children;
	}
	public void setChildren(Set<Department> children) {
		this.children = children;
	}
	@OneToMany(mappedBy="dept",cascade={CascadeType.ALL})
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
}
