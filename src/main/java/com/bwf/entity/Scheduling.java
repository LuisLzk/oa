package com.bwf.entity;
/**
 * 排班表
 * @author admin
 *
 */
public class Scheduling {

	private Integer schedulingId;
	private Integer userId;
	private Integer shiftId;
	public Integer getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(Integer schedulingId) {
		this.schedulingId = schedulingId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getShiftId() {
		return shiftId;
	}
	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}
	@Override
	public String toString() {
		return "Scheduling [schedulingId=" + schedulingId + ", userId=" + userId + ", shiftId=" + shiftId + "]";
	}
	
	
}
