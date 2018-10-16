package com.bwf.dao;

import java.util.List;

import com.bwf.entity.Permission;

public interface PermissionMapper {

	List<Permission> getAllPermissionsByRoleId(Integer roleId);

	List<Permission> getAllPermissions();

}
