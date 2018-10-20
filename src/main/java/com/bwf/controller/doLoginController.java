package com.bwf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.bwf.entity.News;
import com.bwf.service.INews;

/**
 * 首页控制器
 * @author admin
 *
 */
@Controller
public class doLoginController {
	@Autowired
	INews news;
	
	@GetMapping("doLogin")
	public String doLogin(ModelMap modelMap){
		News news2=news.getSingleNews();
		
		modelMap.addAttribute("news2", news2);
		return "login/index";
	}
	
	@GetMapping("home")
	public String home(){
		return "login/home";
	}
}
