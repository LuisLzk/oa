package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IuserService {

	User login(User user);

	List<User> getAllUsers(Integer page, Integer pageSize);

	Integer getAllCounts();

	

	
}
