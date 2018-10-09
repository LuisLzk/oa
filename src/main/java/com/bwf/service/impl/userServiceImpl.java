package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.userMapper;
import com.bwf.entity.User;
import com.bwf.service.IuserService;
@Service
public class userServiceImpl implements IuserService {
	@Autowired
	userMapper mapper;
	@Override
	public User login(User user) {
		User u=mapper.getUserByUserNameAndPassword(user);
		System.out.println(u.getPassword());
		return u;
	}

}
