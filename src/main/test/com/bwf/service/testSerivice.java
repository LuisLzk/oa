package com.bwf.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.service.impl.newsImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class testSerivice {
	//Logger logger = LoggerFactory.getLogger(testSerivice.class);
	
	@Autowired
	newsImpl news;
	
	@Test
	public void serviceTest(){
		news.getNews();
	}
	
	
}
