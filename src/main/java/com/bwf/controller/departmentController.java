package com.bwf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwf.entity.Department;
import com.bwf.entity.User;
import com.bwf.service.IDeportmentService;
import com.bwf.service.IuserService;

@Controller
public class departmentController {
	@Autowired
	IDeportmentService departmentService;
	@Autowired
	IuserService userService;
	
	List<Department> allDepartment;
	@GetMapping("department")
	public String department(ModelMap modelMap){
		//获取所有部门
		allDepartment= departmentService.getAllDeportment();
		
		
		modelMap.addAttribute("allDepartment", allDepartment);
		return "department/department";
	}
	
	//展示部门详情
	@GetMapping("departmentShow")
	public String departmentShow(Integer departmentId,ModelMap modelMap){
		//展示部门领导
		Department leader=departmentService.getDepartmentLeaderByDepartmentId(departmentId);
		System.out.println(leader.getUser());
		//展示下属部门，下属部门领导
		List<Department> allDepartments= departmentService.getAllDeportmentByPId(departmentId);
		List<User> nextDepartmentUser= new ArrayList<>();
		
		for(Department d:allDepartments){
			System.out.println(d.getDepartmentName());
			nextDepartmentUser.addAll(userService.getUsersById(d.getUserId()));
		}
		
		//上级领导
		Department allPrevDepartments= departmentService.getDeportmentByPId(leader.getpId());
		//System.out.println(allPrevDepartments.toString());
		User prevDepartmentUser=null;
		if(leader.getpId()!=null){
			prevDepartmentUser=userService.getUserById(allPrevDepartments.getUserId());
		}
		
		modelMap.addAttribute("leader", leader);
		modelMap.addAttribute("allDepartments", allDepartments);
		modelMap.addAttribute("nextDepartmentUser", nextDepartmentUser);
		modelMap.addAttribute("allPrevDepartments", allPrevDepartments);
		modelMap.addAttribute("prevDepartmentUser", prevDepartmentUser);
		return "department/show";
	}
	
	//添加部门
	@GetMapping("addDepartment")
	public String addDepartment(ModelMap modelMap){
		List<Department> department=departmentService.getAllDeportment();
		List<User> allDepartmentUser=userService.getAllUser();
		
		modelMap.addAttribute("department",department);
		modelMap.addAttribute("allDepartmentUser",allDepartmentUser);
		return "department/addDepartment";
	}
	@PostMapping("doAddDepartment")
	public String doAddDepartment(Department department){
		//System.out.println(department.toString());
		departmentService.addDepartment(department);
		return "redirect:/addDepartment";
	}
	
	//删除部门
	@GetMapping("deleteDepartment")
	public String deleteDepartment(ModelMap modelMap){
		modelMap.addAttribute("allDepartment", allDepartment);
		return "department/deleteDepartment";
	}
	@PostMapping("doDeleteDepartment")
	public String doDeleteDepartment(Integer[] departmentId){
		//System.out.println(departmentId);
		departmentService.deleteDepartmentByDepartmentId(departmentId);
		return "redirect:/deleteDepartment";
	}
	
	//修改部门
	@GetMapping("updateDepartment")
	public String updateDepartment(Integer departmentId,ModelMap modelMap){
		if(departmentId!=null){
		//展示部门领导
		Department leader=departmentService.getDepartmentLeaderByDepartmentId(departmentId);
		//展示下属部门，下属部门领导
		List<Department> allDepartments= departmentService.getAllDeportmentByPId(departmentId);
		List<User> nextDepartmentUser= new ArrayList<>();
		
		for(Department d:allDepartments){
			nextDepartmentUser.addAll(userService.getUsersById(d.getUserId()));
		}
		
		//上级领导
		Department allPrevDepartments= departmentService.getDeportmentByPId(leader.getpId());
		User prevDepartmentUser=null;
		if(leader.getpId()!=null){
			prevDepartmentUser=userService.getUserById(allPrevDepartments.getUserId());
		}
		
		modelMap.addAttribute("departmentId", departmentId);
		modelMap.addAttribute("leader", leader);
		modelMap.addAttribute("allDepartments", allDepartments);
		modelMap.addAttribute("nextDepartmentUser", nextDepartmentUser);
		modelMap.addAttribute("allPrevDepartments", allPrevDepartments);
		modelMap.addAttribute("prevDepartmentUser", prevDepartmentUser);
		}
		
		//所用用户
		List<User> allUsers=userService.getAllUser();
		//所有部门
		List<Department> allOfDepartment=departmentService.getAllDeportment();
		
		modelMap.addAttribute("allDepartment", allDepartment);
		modelMap.addAttribute("allUsers", allUsers);
		modelMap.addAttribute("allOfDepartment", allOfDepartment);
		return "department/updateDepartment";
	}
	@PostMapping("doUpdateDepartment")
	public String doUpdateDepartment(Department department){
		//System.out.println(department);
		departmentService.updateDepartment(department);
		return "redirect:/updateDepartment";
	}
}
