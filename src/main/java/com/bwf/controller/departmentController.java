package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("department")
	public String department(ModelMap modelMap){
		//获取所有部门
		List<Department> allDepartment= departmentService.getAllDeportment();
		
		
		modelMap.addAttribute("allDepartment", allDepartment);
		return "department/department";
	}
	
	//展示部门详情
	@GetMapping("departmentShow")
	public String departmentShow(Integer departmentId){
		//获取所有部门
		List<Department> allDepartment= departmentService.getAllDeportment();	
		//展示部门领导
		String LeaderName=null;
		for(Department d:allDepartment){
			LeaderName=userService.getNickeNameByUserId(d.getpId());
		}
		
			System.out.println(LeaderName);
		
		//展示下属部门，下属部门领导
		//上级领导
		return null;
	}
}
