package com.bwf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.DeportmentMapper;
import com.bwf.entity.Department;
import com.bwf.service.IDeportmentService;
@Service
public class deportmentImpl implements IDeportmentService {
	@Autowired
	DeportmentMapper deportmentMapper;
	
	@Override
	public List<Department> getAllDeportment() {
		// TODO Auto-generated method stub
		return deportmentMapper.getAllDeportment();
	}

	@Override
	public Department getDepartmentLeaderByDepartmentId(Integer departmentId) {
		// TODO Auto-generated method stub
		return deportmentMapper.getDepartmentLeaderByDepartmentId(departmentId);
	}

	@Override
	public List<Department> getAllDeportmentByPId(Integer departmentId) {
		// TODO Auto-generated method stub
		return deportmentMapper.getAllDeportmentByPId(departmentId);
	}

	@Override
	public Department getDeportmentByPId(Integer pId) {
		// TODO Auto-generated method stub
		return deportmentMapper.getDeportmentByPId(pId);
	}

	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		deportmentMapper.addDepartment(department);
	}

	@Override
	public void deleteDepartmentByDepartmentId(Integer[] departmentId) {
		// TODO Auto-generated method stub
		deportmentMapper.deleteDepartmentByDepartmentId(departmentId);
	}

	@Override
	@Transactional
	public void updateDepartment(Department department) {
		//删除原来的部门
		deportmentMapper.deleteDepartmentBySimgleDepartmentId(department.getDepartmentId());
		//添加新的部门
		deportmentMapper.addDepartment(department);
	}

	
}
