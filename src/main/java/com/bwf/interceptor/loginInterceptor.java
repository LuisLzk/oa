package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 拦截未登录
 * @author admin
 *
 */
public class loginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			if(request.getSession().getAttribute("user")==null){
				//没有登录，拦截，跳到登陆界面
				System.out.println("没有登录");
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
			System.out.println("已经登陆");
		return true;
	}
}
