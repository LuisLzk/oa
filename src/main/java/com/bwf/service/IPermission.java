package com.bwf.service;

import java.util.List;

import com.bwf.entity.Permission;

public interface IPermission {

	List<Permission> getAllPermissionsByRoleId(Integer roleId);

	List<Permission> getAllPermissions();

	List<Integer> getAllPermissionIdByPermissions(List<Permission> permissions);

}
