package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Menu;
import com.bwf.entity.User;
import com.bwf.service.IuserService;
import com.bwf.util.StringUtil;
import com.mysql.cj.Session;

/**
 * 用户表控制器
 * @author admin
 *
 */
@Controller
public class UserController {
	Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	IuserService iuserService;
	
	//展示登陆页面
	@GetMapping("login")
	public String login(Integer error,ModelMap modelMap){
		modelMap.addAttribute("error",error);
		return "login/login";
	}
	
	//展示首页
	@PostMapping("doLogin")
	public String doLogin( User user,HttpSession seesion){
		//logger.info("{}","{}",user.getUserName(),user.getPassword());
		System.out.println(user.getUserName()+","+user.getPassword());
		
		User us= iuserService.login(user);
		if(us!=null){
			//登陆成功
			logger.info(us.toString());
			List<Menu> menus=us.getMenus();
			for(Menu m:menus){
				logger.info(m.toString());
			}
			//写入session
			seesion.setAttribute("user", us);
			return "redirect:/doLogin";
		}else{
			//登录失败
			return "redirect:login?error=1";
		}
		
	}
	
	//退出登录
	@GetMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:login";
	}
	
	//显示所有员工
	@GetMapping("show")
	public String show(){
		return "login/show";
	}
}
