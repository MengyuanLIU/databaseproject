package com.tjw.hrmanage.model;

import java.util.Date;


public class Plan {
	private int planId;
	/**
	 * 计划标题
	 */
	private String planTitle;
	/**
	 * 计划负责人
	 */
	private String planMan;
	/**
	 * 计划执行日期
	 */
	private Date planTime;
	/**
	 * 计划内容
	 */
	private String planContent;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanTitle() {
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public String getPlanMan() {
		return planMan;
	}
	public void setPlanMan(String planMan) {
		this.planMan = planMan;
	}
	public Date getPlanTime() {
		return planTime;
	}
	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	
}
