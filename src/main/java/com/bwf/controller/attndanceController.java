package com.bwf.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwf.entity.AllShift;
import com.bwf.service.IWorkInOutSerivce;
@Controller
public class attndanceController {

	@Autowired
	IWorkInOutSerivce workInOutSerivce;
	
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
	
	//排班
	@GetMapping("addShift")
	public String doShift(){
		return "attendance/doShift";
	}
	@PostMapping("doAddShift")
	public String doAddShift(String shiftName,String shiftStartTime,String shiftEndTime){
		System.out.println(shiftName);
		System.out.println(shiftStartTime);
		System.out.println(shiftEndTime);
		return null;
	}
}
