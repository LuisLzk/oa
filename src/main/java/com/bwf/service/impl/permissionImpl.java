package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.PermissionMapper;
import com.bwf.entity.Permission;
import com.bwf.service.IPermission;
@Service
public class permissionImpl implements IPermission {
	@Autowired
		PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> getAllPermissionsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return permissionMapper.getAllPermissionsByRoleId(roleId);
	}

	@Override
	public List<Permission> getAllPermissions() {
		// TODO Auto-generated method stub
		return permissionMapper.getAllPermissions();
	}

	@Override
	public List<Integer> getAllPermissionIdByPermissions(List<Permission> permissions) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		for(Permission p:permissions){
			list.add(p.getPermissionId());
		}
		return list;
	}
	@Transactional
	@Override
	public void updatePermision(Integer roleId, Integer[] permissionId) {
		//删除原来的权限
		permissionMapper.deletePermissionByRoleId(roleId);
		//添加新的权限
		permissionMapper.insertPermission(roleId,permissionId);
	}

}
