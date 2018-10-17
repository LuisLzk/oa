package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.RoleMapper;
import com.bwf.dao.UserRoleMapper;
import com.bwf.entity.Role;
import com.bwf.entity.UserRole;
import com.bwf.service.IRoleService;
@Service
public class roleServiceImpl implements IRoleService {
	@Autowired
	RoleMapper roleMapper;

	@Autowired
	UserRoleMapper userRoleMapper;

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleMapper.getAllRole();
	}



	@Override
	public List<Role> getRoleByUserId(Integer userId) {
		return roleMapper.getRoleById(userId);
	}



	@Override
	public List<Integer> getCurrnetRoleIdBycurrentRole(List<Role> currentRole) {
		List<Integer> list=new ArrayList<>();
		for(Role r:currentRole){
			list.add(r.getRoleId());
		}
		return list;
	}



	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.addRole(role);
	}




	@Override
	public List<Role> getroleByRoleId(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleByRoleId(id);
	}



	@Override
	public void updateRole(Integer userId, List<Role> role) {
		//删除原来的角色
		List<UserRole> userRole=userRoleMapper.getroleIdByUserId(userId);
		for(UserRole u:userRole){
			System.out.println(u.toString());
		}
		roleMapper.deleteRoleByRoleId(userRole);;
		//添加新的角色
		List<Integer> list= roleMapper.addRoles(role);
		
		roleMapper.adduserAndRole(userId,role);
	}



	
}
