package com.bwf.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.WorkInOutMapper;
import com.bwf.entity.User;
import com.bwf.entity.WorkInOut;
import com.bwf.service.IWorkInOutSerivce;
@Service
public class workInOutImpl implements IWorkInOutSerivce {
	@Autowired
	WorkInOutMapper workInOutMapper;
	
	@Override
	public void workIn(String inTime,Object object) {
		// TODO Auto-generated method stub
		DateFormat date1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = null;
		try {
			date=date1.parse(inTime);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user1=(User) object;
		WorkInOut workInOut=new WorkInOut();
		workInOut.setInTime(date);
		workInOut.setUserId(user1.getUserId());
		workInOutMapper.workIn(workInOut);
	}

	@Override
	public void workOut(String outTime, Object attribute) {
		// TODO Auto-generated method stub
		DateFormat date1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = null;
		try {
			date=date1.parse(outTime);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user1=(User) attribute;
		WorkInOut workInOut=new WorkInOut();
		workInOut.setOutTime(date);
		workInOut.setUserId(user1.getUserId());
		workInOutMapper.workOut(workInOut);
	}

}
