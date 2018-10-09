package com.bwf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;
import com.bwf.service.IuserService;
import com.bwf.util.StringUtil;

/**
 * 用户表控制器
 * @author admin
 *
 */
@Controller
@RequestMapping("login")
public class UserController {
	Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	IuserService iuserService;
	
	//展示登陆页面
	@GetMapping("login")
	public String login(){
		//System.out.println("ok");
		return "login/login";
	}
	
	//展示首页
	@PostMapping("doLogin")
	public String doLogin( User user){
		//logger.info("{}","{}",user.getUserName(),user.getPassword());
		System.out.println(user.getUserName()+","+user.getPassword());
		
		//对密码进行加密
		user.setPassword(StringUtil.md5(user.getPassword()));
		logger.info(user.getPassword());
		User us= iuserService.login(user);
		if(us!=null){
			logger.info(us.toString());
		}
		
		return "redirect:/doLogin";
	}
}
