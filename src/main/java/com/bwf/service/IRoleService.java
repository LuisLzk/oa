package com.bwf.service;

import java.util.List;

import com.bwf.entity.Role;

public interface IRoleService {

	List<Role> getAllRole();

	List<Role> getRoleByUserId(Integer userId);

	List<Integer> getCurrnetRoleIdBycurrentRole(List<Role> currentRole);

	void addRole(Role role);

	void updateRole(Integer userId, List<Role> role);

	List<Role> getroleByRoleId(Integer id);

}
