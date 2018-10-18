package com.bwf.service.impl;

import java.util.List;

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

	
}
