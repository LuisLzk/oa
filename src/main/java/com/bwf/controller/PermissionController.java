package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwf.entity.Permission;
import com.bwf.entity.Role;
import com.bwf.service.IPermission;
import com.bwf.service.IRoleService;

/**
 * 权限管理器
 * @author admin
 *
 */
@Controller
public class PermissionController {
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IPermission permission;
	//展示权限管理界面
	@GetMapping("permission")
	public String permission(Integer roleId,ModelMap modelMap){
		List<Role> role=roleService.getAllRole();
		System.out.println(role.toString());
		//当前角色的权限
		List<Permission> permissions=permission.getAllPermissionsByRoleId(roleId);
		//当前角色的权限的permissionId
		List<Integer> permissionIds=permission.getAllPermissionIdByPermissions(permissions);
		//所有的权限
		List<Permission> allPermission=permission.getAllPermissions();
		
		modelMap.addAttribute("role", role);
		modelMap.addAttribute("roleId", roleId);
		modelMap.addAttribute("permissionIds", permissionIds);
		modelMap.addAttribute("allPermission", allPermission);
		return "permission/permission";
	}
	
	//修改权限管理
	@PostMapping("doPermission")
	public String doPermission(Integer roleId,Integer[] permissionId){
		permission.updatePermision(roleId,permissionId);
		return "redirect:/permission";
	}
}
