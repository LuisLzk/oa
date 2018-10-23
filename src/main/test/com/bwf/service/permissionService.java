package com.bwf.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class permissionService {

	@Autowired
	IPermission permission;
	
	@Test
	public void permissionTest(){
		Integer[] id={1,6,7,8,9,10,11};
		permission.updatePermision(null, id);
	}
}
