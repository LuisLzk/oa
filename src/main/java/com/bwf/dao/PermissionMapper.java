package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Permission;

public interface PermissionMapper {

	List<Permission> getAllPermissionsByRoleId(Integer roleId);

	List<Permission> getAllPermissions();

	void deletePermissionByRoleId(Integer roleId);

	void insertPermission(@Param("roleId")Integer roleId, @Param("permissionId")List<Integer> list);

	List<Permission> getPermissionByPid(@Param("permissionId")Integer[] permissionId);

}
