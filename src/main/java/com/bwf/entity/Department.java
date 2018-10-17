package com.bwf.entity;
/**
 * 部门表实体类
 * @author admin
 *
 */
public class Department {

	private Integer departmentId;
	private String departmentName;
	private Integer pId;
	private Integer userId;
	
	//部门领导
	private User leader;
	//部门成员
	private User users;
	
	
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public User getUser() {
		return users;
	}
	public void setUser(User users) {
		this.users = users;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", pId=" + pId
				+ ", userId=" + userId + "]";
	}
	
	
}
