package com.bwf.service;

import java.util.List;

import com.bwf.entity.Department;

public interface IDeportmentService {

	List<Department> getAllDeportment();

	Department getDepartmentLeaderByDepartmentId(Integer departmentId);

	List<Department> getAllDeportmentByPId(Integer departmentId);

	Department getDeportmentByPId(Integer getpId);

	void addDepartment(Department department);

	void deleteDepartmentByDepartmentId(Integer[] departmentId);

	void updateDepartment(Department department);

}
