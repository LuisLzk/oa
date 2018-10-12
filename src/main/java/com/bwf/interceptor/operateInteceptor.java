package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.Operate;
import com.bwf.entity.User;
/**
 * 拦截已登录，但权限不够的操作
 * @author admin
 *
 */
public class operateInteceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		
			boolean sessionContainsUrl=false;
			User user=(User)request.getSession().getAttribute("user");
			for(Operate operate:user.getOperates()){
				System.out.println(operate.getOperateAction());
				if(request.getRequestURI().contains(operate.getOperateAction())){
					sessionContainsUrl=true;
				}
			}
			System.out.println(sessionContainsUrl);
			//判断用户的session.user.operate中是否含有本次操作的权限
			if(sessionContainsUrl){
				//含有本次操作的权限，即允许本次操作
				return true;
			}else{
				//不含本次操作的权限，重定向到报错页面，提醒是用户权限不够
				response.sendRedirect(request.getContextPath()+"/error/error");
				return false;
			}
	}
}
