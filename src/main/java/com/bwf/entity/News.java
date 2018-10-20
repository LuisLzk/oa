package com.bwf.entity;

import java.util.Date;

/**
 * 公告实体类
 * @author admin
 *
 */
public class News {

	private Integer newsId;
	private String newsDetails;
	private Integer userId;
	private Date time;
	
	private String newTime;
	public String getNewTime() {
		return newTime;
	}
	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}
	private User users;
	
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewsDetails() {
		return newsDetails;
	}
	public void setNewsDetails(String newsDetails) {
		this.newsDetails = newsDetails;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsDetails=" + newsDetails + ", userId=" + userId + ", time=" + time
				+ "]";
	}
	
	
}
