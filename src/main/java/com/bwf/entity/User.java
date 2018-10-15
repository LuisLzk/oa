package com.bwf.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 数据库中user表的实体类
 * @author admin
 *
 */
public class User {

	private Integer userId;
	@NotNull
	private String userName;
	@Pattern(regexp="^[0-9]{6,12}$")
	private String password;
	@NotNull
	private String nickName;
	private Integer leaderId;
	private String avater;
	
	private List<Menu> menus;
	private List<Operate> operates;
	
	private User leader;
	
	
	
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public List<Operate> getOperates() {
		return operates;
	}
	public void setOperates(List<Operate> operates) {
		this.operates = operates;
	}
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", nickName=" + nickName
				+ ", leaderId=" + leaderId + ", avater=" + avater + "]";
	}
	
	
	
}
