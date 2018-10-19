package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Department;

public interface DeportmentMapper {

	List<Department> getAllDeportment();

	Department getDepartmentLeaderByDepartmentId(@Param("departmentId")Integer departmentId);

	List<Department> getAllDeportmentByPId(@Param("departmentId")Integer departmentId);

	Department getDeportmentByPId(@Param("pId")Integer pId);

	void addDepartment(Department department);

	void deleteDepartmentByDepartmentId(@Param("departmentId")Integer[] departmentId);

	void deleteDepartmentBySimgleDepartmentId(@Param("id")Integer departmentId);


}
