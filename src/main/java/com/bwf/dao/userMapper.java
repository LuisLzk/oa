package com.bwf.dao;

import com.bwf.entity.User;
public interface userMapper {

	User getUserById();

	User getUserByUserNameAndPassword(User user);
}
