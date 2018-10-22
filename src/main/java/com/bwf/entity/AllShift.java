package com.bwf.entity;

import java.util.Date;

/**
 * 班次名称表
 * @author admin
 *
 */
public class AllShift {

	private Integer shiftId;
	private String shiftName;
	private Date shiftStartTime;
	private Date shiftEndTime;
	public Integer getShiftId() {
		return shiftId;
	}
	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public Date getShiftStartTime() {
		return shiftStartTime;
	}
	public void setShiftStartTime(Date shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}
	public Date getShiftEndTime() {
		return shiftEndTime;
	}
	public void setShiftEndTime(Date shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
	}
	@Override
	public String toString() {
		return "AllShift [shiftId=" + shiftId + ", shiftName=" + shiftName + ", shiftStartTime=" + shiftStartTime
				+ ", shiftEndTime=" + shiftEndTime + "]";
	}
	
	
}
