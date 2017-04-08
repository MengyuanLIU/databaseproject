package com.tjw.hrmanage.model;

import java.util.Date;

/**
 *管理员
 */
public class Manager implements java.io.Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *管理员id
	 */
	private int managerId;
	 
	/**
	 *登陆账号
	 */
	private String account;
	 
	/**
	 *登陆密码
	 */
	private String password;
	 
	/**
	 *管理员级别(1为系统管理员，0为普通管理员)
	 */
	private String managerLevel;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 注册日期
	 */
	private Date regDate;
	/**
	 * 登录次数
	 */
	private int loginCnt;
	
	/**
	 * 上次登录时间
	 */
	private String lastLoginDate;
	
	/**
	 * 本次登录时间
	 */
	private String currLoginDate;
	
	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	public String getCurrLoginDate() {
		return currLoginDate;
	}

	public void setCurrLoginDate(String currLoginDate) {
		this.currLoginDate = currLoginDate;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getLoginCnt() {
		return loginCnt;
	}

	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}


	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getManagerLevel() {
		return managerLevel;
	}

	public void setManagerLevel(String managerLevel) {
		this.managerLevel = managerLevel;
	}
	 
}
 
