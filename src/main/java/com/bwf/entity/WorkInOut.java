package com.bwf.entity;

import java.util.Date;

/**
 * 签到签退表
 * @author admin
 *
 */
public class WorkInOut {

	private Integer workInOutId;
	private Integer userId;
	private Date inTime;
	private Date outTime;
	public Integer getWorkInOutId() {
		return workInOutId;
	}
	public void setWorkInOutId(Integer workInOutId) {
		this.workInOutId = workInOutId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	@Override
	public String toString() {
		return "WorkInOut [workInOutId=" + workInOutId + ", userId=" + userId + ", inTime=" + inTime + ", outTime="
				+ outTime + "]";
	}
	
	
}
