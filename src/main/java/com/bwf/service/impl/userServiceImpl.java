package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IuserService;
import com.bwf.util.StringUtil;
@Service
public class userServiceImpl implements IuserService {
	@Autowired
	UserMapper userMapper;
	@Override
	public User login(User user) {
		//对密码进行加密
		user.setPassword(StringUtil.md5(user.getPassword()));
		System.out.println(user.getPassword());
		User u=userMapper.getUserByUserNameAndPassword(user);
		if(u!=null){
			//根据用户Id获取菜单和功能操作
			User user1=userMapper.getMenuAndoperateByUserId(u.getUserId());
			return user1;
		}
		return u;
	}
	@Override
	public List<User> getAllUsers(Integer page,Integer pageSize) {
		List<User> users=userMapper.getAllUsers((page-1)*pageSize,pageSize);
		return users;
	}
	@Override
	public Integer getAllCounts() {
		
		return userMapper.getAllCounts();
	}
	@Override
	public List<User> getAllUser() {
		
		return userMapper.getAllUser();
	}
	@Override
	public User checkUser(String userName) {
		// TODO Auto-generated method stub
		return userMapper.checkUser(userName);
	}
	
}
