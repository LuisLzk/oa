package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwf.entity.Menu;
import com.bwf.entity.User;
import com.bwf.service.IuserService;

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
	public String show(ModelMap modelMap,Integer page){
		if(page==null){
			page=1;
		}
		//每页10条数据
		Integer pageSize=10;
		//总共有多少条数据
		Integer allCount=iuserService.getAllCounts();
		//分多少页
		Integer allPage=(int)Math.ceil(allCount*1.0/pageSize);
		//分页
		List<User> allUsers=iuserService.getAllUsers(page,pageSize);
		
		modelMap.addAttribute("allUsers",allUsers);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("allPage", allPage);
		
		return "login/show";
	}
	
	//添加用户
	@GetMapping("add")
	public String add(ModelMap modelMap){
		modelMap.addAttribute("allUser", iuserService.getAllUser());
		return "login/add";
	}
	
	@PostMapping("doAdd")
	public String doAdd(User us){
		System.out.println("提交成功");
		logger.info(us.getNickName());
		logger.info(us.getLeader().getUserId()+"");
		
		return "redirect:/add";
	}
	//验证用户名
	@RequestMapping("addUser")
	@ResponseBody
	public Integer addUser(HttpServletRequest req){
		System.out.println(req.getParameter("userName"));
		User user=iuserService.checkUser(req.getParameter("userName"));
		if(user!=null){
			System.out.println("用户名不可用！");
			return 1;
		}else{
			System.out.println("用户名可用！");
			return 0;
		}
	}
}
