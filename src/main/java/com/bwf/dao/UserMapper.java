package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.User;
public interface UserMapper {

	User getUserById(Integer userId);

	User getUserByUserNameAndPassword(User user);

	User getMenuAndoperateByUserId(Integer userId);

	List<User> getAllUsers(@Param("page")Integer page,@Param("pageSize") Integer pageSize);

	Integer getAllCounts();

	List<User> getAllUser();

	User checkUser(@Param("userName")String userName);

	void add(User us);

	void deletUser(Integer userId);

	void deletUsers(@Param("idList")Integer[] idList);

	void updatewithPassword(User user);

	void updatewithoutPassword(User user);

	String getNickeNameByUserId(@Param("pId")Integer pId);

	
}
