package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bwf.entity.News;
import com.bwf.entity.User;
import com.bwf.service.INews;

@Controller
public class newsCotroller {
	@Autowired
	INews news;
	
	@GetMapping("news")
	public String news(ModelMap modelMap){
		List<News> allNews=news.getNews();
		
		modelMap.addAttribute("allNews", allNews);
		return "news/news";
	}
	
	//添加公告
	@GetMapping("addNews")
	public String addNews(){
		return "news/addNews";
	}
	@PostMapping("doAddNews")
	public String doAddNews(String newsDetails,HttpSession session){
		System.out.println(newsDetails);
		News news1=new News();
		User u=(User) session.getAttribute("user");
		news1.setUserId(u.getUserId());
		news1.setNewsDetails(newsDetails);
		
		news.addNews(news1);
		return "redirect:addNews";
	}
	
	//删除公告
	@GetMapping("deleteNews")
	public String deleteNews(ModelMap modelMap){
		List<News> newsMore= news.getSomeNews();
		modelMap.addAttribute("newsMore", newsMore);
		return "news/deleteNews";
	}
	@GetMapping("doDeleteNews")
	public String doDeleteNews(Integer newsId){
		//System.out.println(newsId);
		news.deleteNewsByNewsId(newsId);
		
		return "redirect:deleteNews";
	}
}
