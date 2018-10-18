package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.UserRole;

public interface UserRoleMapper {

	List<UserRole> getroleIdByUserId(@Param("userId")Integer userId);

	void deleteByUserId(@Param("userId")Integer userId);

}
