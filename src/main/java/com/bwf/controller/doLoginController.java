package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 * @author admin
 *
 */
@Controller
public class doLoginController {

	@GetMapping("doLogin")
	public String doLogin(){
		return "login/index";
	}
	
	@GetMapping("home")
	public String home(){
		return "login/home";
	}
}
