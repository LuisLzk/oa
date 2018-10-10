package com.bwf.dao;

import com.bwf.entity.User;
public interface UserMapper {

	User getUserById();

	User getUserByUserNameAndPassword(User user);

	User getMenuAndoperateByUserId(Integer userId);
}
