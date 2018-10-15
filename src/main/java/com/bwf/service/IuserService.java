package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IuserService {

	User login(User user);

	List<User> getAllUsers(Integer page, Integer pageSize);

	Integer getAllCounts();

	List<User> getAllUser();

	User checkUser(String userName);

	void add(User us);

	void deletUser(Integer userId);

	void deletUsers(Integer[] idList);

	User getUserById(Integer userId);

	void updateUser(User user, boolean b);

	
	

	
}
