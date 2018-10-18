package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Role;
import com.bwf.entity.UserRole;

public interface RoleMapper {

	List<Role> getAllRole();

	List<Role> getRoleById(@Param("userId")Integer userId);

	void addRole(Role role);

	List<Role> getRoleByRoleId(@Param("roleId")Integer id);

	Integer addRoles(@Param("role")List<Role> role);

	Integer getroleIdByUserId(@Param("userId")Integer userId);

	void deleteRoleByRoleId(@Param("roleId")Integer[] roleId);

	void adduserAndRole(@Param("userId")Integer userId, @Param("role")List<Role> role);

}
