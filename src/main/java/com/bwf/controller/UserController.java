package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		//System.out.println(user.getUserName()+","+user.getPassword());
		
		User us= iuserService.login(user);
		if(us!=null){
			//登陆成功
			//logger.info(us.toString());
			List<Menu> menus=us.getMenus();
//			for(Menu m:menus){
//				logger.info(m.toString());
//			}
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
	public String doAdd(@Valid User us,BindingResult bindingResult,ModelMap modelMap){
		
		//logger.info(us.getNickName());
		//logger.info(us.getLeader().getUserId()+"");
		us.setLeaderId(us.getLeader().getUserId());
		//检验参数是否合法
		if(bindingResult.hasErrors()){
			//System.out.println(bindingResult.getAllErrors());
			modelMap.addAttribute("error", bindingResult.getAllErrors());
			return "redirect:/add";
		}else{
			iuserService.add(us);
			return "redirect:/show";
		}
		
	}
	//验证用户名
	@RequestMapping("addUser")
	@ResponseBody
	public Integer addUser(HttpServletRequest req){
		//System.out.println(req.getParameter("userName"));
		User user=iuserService.checkUser(req.getParameter("userName"));
		if(user!=null){
			System.out.println("用户名不可用！");
			return 1;
		}else{
			System.out.println("用户名可用！");
			return 0;
		}
	}
	
	//删除单个用户
	@GetMapping("deletUser/{userId}")
	public String deletUser(@PathVariable Integer userId){
		iuserService.deletUser(userId);
		return "redirect:/show";
	}
	
	//删除多个员工
	@GetMapping("deletUser")
	public String deletUser(Integer[] userId){
//		for(Integer id:userId){
//			System.out.println(id);
//		}
		if(userId!=null){
		iuserService.deletUsers(userId);
		}else{
			return "redirect:/show";
		}
		return "redirect:/show";
	}
	
	//编辑员工信息
	@GetMapping("editUser/{userId}")
	public String editUser(@PathVariable Integer userId,ModelMap modelMap){
		//logger.info(userId+"");
		User user1=iuserService.getUserById(userId);
		//logger.info(user1.toString());
		List<User>users=iuserService.getAllUser();
		modelMap.addAttribute("user1", user1);
		modelMap.addAttribute("users", users);
		return "login/edit";
	}
	@PostMapping("doEdit")
	public String doEdit(User user,String resetPassword){
		//logger.info(user.toString());
		//logger.info("是否修改密码：{}", resetPassword!=null);
		
		iuserService.updateUser(user,resetPassword!=null);
		return "redirect:/show";
	}
}
