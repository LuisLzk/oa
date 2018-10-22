package com.bwf.entity;
/**
 * 假期名称表
 * @author admin
 *
 */
public class Holiday {

	private Integer holidayId;
	private String holidayName;
	public Integer getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", holidayName=" + holidayName + "]";
	}
	
	
}
