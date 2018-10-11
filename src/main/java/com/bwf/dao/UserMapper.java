package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.User;
public interface UserMapper {

	User getUserById();

	User getUserByUserNameAndPassword(User user);

	User getMenuAndoperateByUserId(Integer userId);

	List<User> getAllUsers(@Param("page")Integer page,@Param("pageSize") Integer pageSize);

	Integer getAllCounts();
}
