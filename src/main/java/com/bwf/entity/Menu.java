package com.bwf.entity;
/**
 * 菜单表的实体类
 * @author admin
 *
 */
public class Menu {

	private Integer menuId;
	private String MenuName;
	private String menuUrl;
	private Integer pId;
	public Menu(Integer menuId, String menuName, String menuUrl, Integer pId) {
		super();
		this.menuId = menuId;
		MenuName = menuName;
		this.menuUrl = menuUrl;
		this.pId = pId;
	}
	public Menu() {
		super();
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return MenuName;
	}
	public void setMenuName(String menuName) {
		MenuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", MenuName=" + MenuName + ", menuUrl=" + menuUrl + ", pId=" + pId + "]";
	}
	
	
}
