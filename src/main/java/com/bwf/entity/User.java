package com.bwf.entity;
/**
 * 数据库中user表的实体类
 * @author admin
 *
 */
public class User {

	private Integer userId;
	private String userName;
	private String password;
	private String nickName;
	private Integer leaderId;
	private String avater;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public User(Integer userId, String userName, String password, String nickName, Integer leaderId, String avater) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.leaderId = leaderId;
		this.avater = avater;
	}
	public User() {
		super();
	}
	
	
	
}
