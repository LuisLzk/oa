package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwf.entity.User;
import com.bwf.service.IDeportmentService;
import com.bwf.service.IWorkInOutSerivce;
@Controller
public class attndanceController {

	@Autowired
	IWorkInOutSerivce workInOutSerivce;
	
	@Autowired
	IDeportmentService departmentService;
	
	@GetMapping("attendance")
	public String attendance(String outTime,String inTime,HttpSession session){
		if(inTime!=null){
			//签到
			workInOutSerivce.workIn(inTime,session.getAttribute("user"));
		}
		if(outTime!=null){
			//签退
			workInOutSerivce.workOut(outTime,session.getAttribute("user"));
		}
		return "attendance/attendance";
	}
	
	//创建班次
	@GetMapping("addShift")
	public String doShift(){
		return "attendance/doShift";
	}
	@PostMapping("doAddShift")
	public String doAddShift(String shiftName,String shiftStartTime,String shiftEndTime){
		workInOutSerivce.addShift(shiftName,shiftStartTime,shiftEndTime);
		return "redirect:addShift";
	}
	
	//排班
	@GetMapping("doRoster")
	public String doRoster(HttpSession session){
		User user1=(User) session.getAttribute("user");
		departmentService.getCurrentDepartmentByUserId(user1.getUserId());
		return null;
	}
}
