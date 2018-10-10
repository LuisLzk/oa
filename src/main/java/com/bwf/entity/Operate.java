package com.bwf.entity;
/**
 * 功能操作标的实体类
 * @author admin
 *
 */
public class Operate {

	private Integer operateId;
	private String operateName;
	private String operateAction;
	private String operateUrl;
	private Integer pId;
	public Operate(Integer operateId, String operateName, String operateAction, String operateUrl, Integer pId) {
		super();
		this.operateId = operateId;
		this.operateName = operateName;
		this.operateAction = operateAction;
		this.operateUrl = operateUrl;
		this.pId = pId;
	}
	public Operate() {
		super();
	}
	public Integer getOperateId() {
		return operateId;
	}
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getOperateAction() {
		return operateAction;
	}
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}
	public String getOperateUrl() {
		return operateUrl;
	}
	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Operate [operateId=" + operateId + ", operateName=" + operateName + ", operateAction=" + operateAction
				+ ", operateUrl=" + operateUrl + ", pId=" + pId + "]";
	}
	
	
	
}
