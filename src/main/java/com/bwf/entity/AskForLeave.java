package com.bwf.entity;

import java.util.Date;

/**
 * 请假记录表
 * @author admin
 *
 */
public class AskForLeave {

	private Integer leaveId;
	private Integer userId;
	private Integer holidayId;
	private Date startTime;
	private Date endTime;
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "AskForLeave [leaveId=" + leaveId + ", userId=" + userId + ", holidayId=" + holidayId + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	
	
}
