package com.bwf.service;

public interface IWorkInOutSerivce {

	void workIn(String inTime, Object object);

	void workOut(String outTime, Object attribute);

	void addShift(String shiftName, String shiftStartTime, String shiftEndTime);

}
