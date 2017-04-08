package com.tjw.hrmanage.model;
import java.util.Date;


/**
 *部门
 */
public class Department {
 
	/**
	 *部门id
	 */
	private int deptId;
	 
	/**
	 *部门名称
	 */
	private String deptName;
	 
	/**
	 *创建时间(创建的系统时间)
	 */
	private Date createTime;
	 
	/**
	 *部门人数
	 */
	private int peopleNum;
	 
	/**
	 *注备
	 */
	private String deptNote;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getDeptNote() {
		return deptNote;
	}

	public void setDeptNote(String deptNote) {
		this.deptNote = deptNote;
	}
	 

	 
	
	 
}
 
