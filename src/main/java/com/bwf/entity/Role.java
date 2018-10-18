package com.bwf.entity;
/**
 * 角色表实体类
 * @author admin
 *
 */
public class Role {

	private Integer roleId;
	private String roleName;
	private Integer departmentId;
	
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", departmentId=" + departmentId + "]";
	}
	public Role(Integer roleId, String roleName, Integer departmentId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.departmentId = departmentId;
	}
	public Role() {
		super();
	}
	
	
	
}
