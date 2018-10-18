package com.bwf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwf.entity.Department;
import com.bwf.entity.Role;
import com.bwf.entity.User;
import com.bwf.service.IDeportmentService;
import com.bwf.service.IRoleService;
import com.bwf.service.IuserService;

@Controller
public class RoleController {
	@Autowired
	IuserService userService;
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IDeportmentService deportmentService;
	
	@GetMapping("role")
	public String role(Integer userId,ModelMap modelMap){
		List<User> allUser=userService.getAllUser();
		
		//获取所有角色
		List<Role> allRole=roleService.getAllRole();
		
		//获取当前用户的角色
		List<Role> currentRole=roleService.getRoleByUserId(userId);
		//获取当前用户的roleId
		List<Integer> currentRoleId=roleService.getCurrnetRoleIdBycurrentRole(currentRole);
		
		modelMap.addAttribute("allRole", allRole);
		modelMap.addAttribute("currentRoleId", currentRoleId);
		modelMap.addAttribute("allUser", allUser);
		modelMap.addAttribute("userId", userId);
		return "role/role";
	}
	
	//添加角色
	@GetMapping("addRole")
	public String addRole(ModelMap modelMap){
		List<Department> deportment=deportmentService.getAllDeportment();
		
		modelMap.addAttribute("deportment", deportment);
		return "role/addRole";
	}
	@PostMapping("doAddRole")
	public String doAddRole(Role role){
		roleService.addRole(role);
		return "redirect:addRole";
	}
	
	
	//修改角色
	@PostMapping("updateRole")
	public String updateRole(Integer userId,Integer[] roleId){
		
		List<Role>role = new ArrayList<>();
		
		for(int i=0;i<roleId.length;i++){
			role.addAll( roleService.getroleByRoleId(roleId[i]));
		}
		roleService.updateRole(userId,role);
		return "redirect:role";
	}
	
	//删除角色
	@PostMapping("deleteRole")
	public String deleteRole(Integer[] roleId){
		roleService.deleteRoleByRoleId(roleId);
		return "redirect:role";
	}
}
